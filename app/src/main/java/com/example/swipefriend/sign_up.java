package com.example.swipefriend;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class sign_up extends AppCompatActivity {
    TextView SignupTextView, ErrorTextView;
    Button button;
    EditText fullname, email, password, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SignupTextView = findViewById(R.id.signupTextView);
        button = findViewById(R.id.loginbutton);
        fullname = findViewById(R.id.editTextFullName);
        email = findViewById(R.id.editTextTextEmailAddress2);
        password = findViewById(R.id.editTextTextPassword2);
        password2 = findViewById(R.id.editTextTextPassword);
ErrorTextView = findViewById(R.id.ErrorTextView_signup);

        SignupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sign_up.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(fullname.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty() || password2.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),  "Fields cannot empty", Toast.LENGTH_SHORT).show();
                }
                else if(!password.getText().toString().equals( password2.getText().toString()))
                {
                    ErrorTextView.setText("Passwords do not match");
                }
                else{
                    FirebaseDatabase.getInstance().getReference("Users").orderByChild("email").equalTo(email.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists())
                            {
                                Toast.makeText(getApplicationContext(),  "Email is exists", Toast.LENGTH_SHORT).show();
                                ErrorTextView.setText("This email address already exists");
                                    email.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.red));
                            }
                            else
                            {
                                                /*
                                                     HashMap<String,String> userinfo = new HashMap<>();
                                                    userinfo.put("email", email.getText().toString());
                                                    userinfo.put("username",fullname.getText().toString());

                                                    FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userinfo);
                                                      */
                                                    UserDataGlobal userDataGlobal = UserDataGlobal.getInstance();

                                                    userDataGlobal.setEmail(email.getText().toString());
                                                    userDataGlobal.setUsername(fullname.getText().toString());
                                                    userDataGlobal.setPassword(password.getText().toString());

                                                    Intent intent = new Intent(sign_up.this, questions.class);
                                                    startActivity(intent);
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }
            }
        });
    }
}