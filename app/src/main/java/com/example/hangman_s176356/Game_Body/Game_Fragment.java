package com.example.hangman_s176356.Game_Body;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hangman_s176356.AddPlayer;
import com.example.hangman_s176356.Game_Logic.Hangman_Logic;
import com.example.hangman_s176356.Game_Logic.Logic;
import com.example.hangman_s176356.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Game_Fragment extends Fragment {

    FloatingActionButton floatingActionButton;
    Button start_game;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_, container, false);
        start_game = view.findViewById(R.id.start_game);
        start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Hangman_Logic.class);
                startActivity(intent);
            }
        });

        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        return view;
    }
    public void onClick(View view) {
        AddPlayer fragment2 = new AddPlayer();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.game_fragment_id, fragment2);
        fragmentTransaction.commit();
    }
}