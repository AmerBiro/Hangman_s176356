package com.example.hangman_s176356.mainpage_fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.hangman_s176356.childpages.HangmanGame;
import com.example.hangman_s176356.databinding.FragmentPage02GamefragmentBinding;
import com.example.hangman_s176356.player.CreatePlayer;

public class Page02_GameFragment extends Fragment {
    private FragmentPage02GamefragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_game_, container, false);

        binding = FragmentPage02GamefragmentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        binding.startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HangmanGame.class);
                startActivity(intent);
            }
        });

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreatePlayer.class);
                startActivity(intent);
            }
        });

        return view;
    }
}