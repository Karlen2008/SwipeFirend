package com.example.swipefriend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;


 public class HomeFragment extends Fragment {

    ArrayList<String> biostrings;
    ArrayAdapter arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        biostrings = new ArrayList<String>();
        biostrings.add("Hey, I'm Alex Turner, a 24-year-old tech whiz passionate about coding and exploring the endless possibilities of software development. In the lines of code, I find my creative outlet and thrive on the ever-evolving digital frontier.");
        biostrings.add("Hi, I'm Sophie Reed, a 27-year-old nature lover with a penchant for environmental advocacy and a talent for sustainable design. Whether I'm planting trees or crafting eco-friendly spaces.");
        biostrings.add("Hey, I'm Liam Foster, a 22-year-old music aficionado who finds solace and inspiration in the rhythms of jazz. As a saxophonist, I weave emotions into melodies, connecting with the soul of this timeless art form. .");
        biostrings.add("Hi, I'm Maya Patel, a 29-year-old fitness coach fueled by a love for empowering others and a dedication to health. In the gym, I channel my passion for well-being, guiding individuals on their fitness journey. E.");
        biostrings.add("Hello, I'm Ryan Carter, a 25-year-old aspiring chef driven by a deep appreciation for culinary artistry. In the kitchen, I blend flavors and textures, creating dishes that tell a story on each plate. .");
        biostrings.add("Greetings, I'm Olivia Turner, a 30-year-old wanderlust-filled travel blogger with an insatiable curiosity for diverse cultures.");

        SwipeFlingAdapterView swipeFlingAdapterView = view.findViewById(R.id.card2);

        arrayAdapter = new ArrayAdapter<String>(requireContext(), R.layout.details, R.id.editTextText_bio, biostrings);

        swipeFlingAdapterView.setAdapter(arrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                biostrings.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {
                Toast.makeText(requireContext(), "LEFT", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object o) {
                Toast.makeText(requireContext(), "RIGHT", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
            }

            @Override
            public void onScroll(float v) {
            }
        });

        return view;
    }
}
