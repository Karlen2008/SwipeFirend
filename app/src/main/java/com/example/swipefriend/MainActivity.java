package com.example.swipefriend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class MainActivity extends AppCompatActivity {
TextView signupTextView, errortextview;
EditText email, password;
Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextTextEmailAddress2);
        password = findViewById(R.id.editTextTextPassword2);
          button = findViewById(R.id.loginbutton);
          errortextview = findViewById(R.id.ErrorTextView_login);


        signupTextView = findViewById(R.id.signupTextView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(email.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),  "Fields cannot empty", Toast.LENGTH_SHORT).show();

                }
                else {



                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                       if(task.isSuccessful())
                                       {
                                           Intent intent = new Intent(MainActivity.this, Home.class);
                                           startActivity(intent);
                                       }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    if (e instanceof FirebaseAuthInvalidUserException  ||  e instanceof FirebaseAuthInvalidCredentialsException) {
                                        errortextview.setText("Invalid email or password");
                                        email.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this,  R.color.red));
                                        password.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.red));

                                    }
                                    else {

                                    }
                                }
                            });
                }
            }
        });
        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, sign_up.class);
                startActivity(intent);
            }
        });
    }
}
