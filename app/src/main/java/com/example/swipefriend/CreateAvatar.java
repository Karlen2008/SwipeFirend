package com.example.swipefriend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapter.AvatarAdapter;
import Model.Avatar;


public class CreateAvatar extends AppCompatActivity {
RecyclerView recyclerView ;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_avatar);
        recyclerView = findViewById(R.id.avatarrecycleview);
        button = findViewById(R.id.nextbutton);




        List<Avatar> avatars = new ArrayList<>();
       // avatars.add(new Avatar(R.drawable.avatar_2));
        avatars.add(new Avatar(R.drawable.avatar_3));
        avatars.add(new Avatar(R.drawable.avatar_4));
        avatars.add(new Avatar(R.drawable.avatar_5));
        avatars.add(new Avatar(R.drawable.avatar_6));
        avatars.add(new Avatar(R.drawable.avatar_7));
        avatars.add(new Avatar(R.drawable.avatar_8));
        avatars.add(new Avatar(R.drawable.avatar_9));

        AvatarAdapter adapter = new AvatarAdapter(avatars, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(adapter.getSelectedPosition() != RecyclerView.NO_POSITION) {
            Intent intent1 = getIntent();
            Intent intent = new Intent(CreateAvatar.this, ProfilePreviewActivity.class);
            intent.putExtra("bio", intent1.getStringExtra("bio"));
            intent.putExtra("avatar", avatars.get(adapter.getSelectedPosition()).getImage());
            startActivity(intent);
        }
    }
});


    }
}