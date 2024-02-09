package com.example.swipefriend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class sign_up extends AppCompatActivity {
    TextView SignupTextView;
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
                else {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                HashMap<String,String> userinfo = new HashMap<>();
                                userinfo.put("email", email.getText().toString() );
                                userinfo.put("username",password.getText().toString());
                                FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userinfo);

                                Intent intent = new Intent(sign_up.this, registrationcomplate.class);
                                startActivity(intent);
                            }
                        }
                    });

                }
            }
        });
    }
}