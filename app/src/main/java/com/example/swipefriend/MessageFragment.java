package com.example.swipefriend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import Adapter.ChatAdapter;
import Model.ChatItemModel;


public class MessageFragment extends Fragment {
    RecyclerView ChatrecyclerView;
    ChatAdapter chatAdapter;
    ChatItemModel chatItemModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        ChatrecyclerView = view.findViewById(R.id.chatRecyclerView);
        List<ChatItemModel> chatItemModels  =new ArrayList<>();

        chatItemModels.add(new ChatItemModel(4, "dwr.eth", "11:47", "Hi! I'm sharing an exclusive invit..."));
        chatItemModels.add(new ChatItemModel(0, "Jasmine Essim",  "13:00", "Let me call my agency"));
        chatItemModels.add(new ChatItemModel(5, "stani", "8:30", "So let me know when you’re..." ));
        chatItemModels.add(new ChatItemModel(2, "Jacques Webster","19 jan",  "For sure!" ));
        chatItemModels.add(new ChatItemModel(1, "Jasmine Essim",  "23 jane", "asd" ));





        chatAdapter = new ChatAdapter(chatItemModels, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        ChatrecyclerView.setLayoutManager(layoutManager);
       ChatrecyclerView.setAdapter(chatAdapter);

        return view;
    }
}