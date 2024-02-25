package com.example.swipefriend;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class AccountFragment extends Fragment {

  ImageButton Exitbutton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        FrameLayout frameLayout = view.findViewById(R.id.frameaccaount);
        Exitbutton = view.findViewById(R.id.exitimagebutton);
        View newLayout = getLayoutInflater().inflate(R.layout.details, frameLayout, false);
        frameLayout.addView(newLayout);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if(currentUser != null)
        {
            String uid = currentUser.getUid();

            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists())
                    {
                        Avatargetter avatargetter = new Avatargetter();
                        TextView bio = newLayout.findViewById(R.id.editTextText_bio);
                        TextView fullname = newLayout.findViewById(R.id.fullname);
                        ImageView  imageView = newLayout.findViewById(R.id.imageView14);
                        bio.setText(snapshot.child("bio").getValue(String.class));
                        fullname.setText(snapshot.child("fullname").getValue(String.class));
                     int a =   snapshot.child("avatar").getValue(Integer.class);
                        imageView.setImageResource(avatargetter.getAvatarbyindex(a).getImage()); //snapshot.child("avatar").getValue(int.class));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        Exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}