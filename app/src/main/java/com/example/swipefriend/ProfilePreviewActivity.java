package com.example.swipefriend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ProfilePreviewActivity extends AppCompatActivity {
ImageView imageView;
Button button;
EditText editText;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_preview);
        button = findViewById(R.id.finish);
textView = findViewById(R.id.textView5);
        Intent intent = getIntent();
        UserDataGlobal userDataGlobal = UserDataGlobal.getInstance();
        editText = findViewById(R.id.editTextText_bio1);
        editText.setText(userDataGlobal.getBio());

        int imageid =intent.getIntExtra("avatar", 0);
        imageView = findViewById(R.id.imageView13);




        textView.setText( userDataGlobal.getAnswers().toString() );

        imageView.setImageResource(imageid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(userDataGlobal.getEmail(), userDataGlobal.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            HashMap<String, Object> bioHashMap= new HashMap<>();

                            bioHashMap.put("email", userDataGlobal.getEmail());
                            bioHashMap.put("fullname", userDataGlobal.getUsername());
                            bioHashMap.put("bio", userDataGlobal.getBio());
                            bioHashMap.put("answers", userDataGlobal.getAnswers().toString());
                            bioHashMap.put("avatar", userDataGlobal.getAvatar_index());


                            FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(bioHashMap);

                            Intent intent = new Intent(ProfilePreviewActivity.this, registrationcomplate.class);

                            startActivity(intent);

                            finishAffinity();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Error, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
    }
}