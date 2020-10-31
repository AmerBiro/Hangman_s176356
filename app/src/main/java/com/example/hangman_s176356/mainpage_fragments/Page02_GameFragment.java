package com.example.hangman_s176356.mainpage_fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.hangman_s176356.childpages.Page02_2_ChildGame;
import com.example.hangman_s176356.databinding.FragmentGameBinding;

public class Page02_GameFragment extends Fragment {
    private FragmentGameBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_game_, container, false);

        binding = FragmentGameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        binding.startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Page02_2_ChildGame.class);
                startActivity(intent);
            }
        });

        return view;
    }
}