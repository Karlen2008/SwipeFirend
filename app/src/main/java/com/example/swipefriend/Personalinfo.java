package com.example.swipefriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Personalinfo extends AppCompatActivity {
      TextView textView ;
Button NextButton;

EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);
        textView = findViewById(R.id.textView6);
       NextButton = findViewById(R.id.loginbutton);
        editText = findViewById(R.id.editTextText_bio);


      NextButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(editText.getText().length() >=45 && editText.getText().length() <=121) {
                  Intent intent = new Intent(Personalinfo.this, CreateAvatar.class);
                  intent.putExtra("bio", editText.getText().toString());
                  startActivity(intent);
              }
          }
      });
        Intent intent = getIntent();
        List<String> receivedList = intent.getStringArrayListExtra("answers");
        String str = "";

        for (int i = 0; i < receivedList.size(); i++)
        {
            str +=receivedList.get(i);
            str+= " ";
        }
        textView.setText(str);
    }
}