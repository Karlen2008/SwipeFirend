package com.example.swipefriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfilePreviewActivity extends AppCompatActivity {
ImageView imageView;
Button button;
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_preview);
        button = findViewById(R.id.finish);

        Intent intent = getIntent();
        editText = findViewById(R.id.editTextText_bio1);
        editText.setText(intent.getStringExtra("bio"));

        int imageid =intent.getIntExtra("avatar", 0);
        imageView = findViewById(R.id.imageView13);


        imageView.setImageResource(imageid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePreviewActivity.this, Home.class);
                startActivity(intent);

            }
        });
    }
}