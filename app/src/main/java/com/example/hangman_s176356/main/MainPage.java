package com.example.hangman_s176356.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.hangman_s176356.R;
import com.example.hangman_s176356.adapters.MainPage_Fragments_Adapter;
import com.example.hangman_s176356.databinding.MainpageBinding;
import com.example.hangman_s176356.mainpage_fragments.Page03_ScoreFragment;
import com.example.hangman_s176356.mainpage_fragments.Page01_RulesFragment;
import com.example.hangman_s176356.mainpage_fragments.Page02_MainMenuFragment;

public class MainPage extends AppCompatActivity {
    private MainpageBinding binding;

    private Page01_RulesFragment page01Rules_fragment;
    private Page02_MainMenuFragment page02Game_fragment;
    private Page03_ScoreFragment page03ScoreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        binding = MainpageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        page01Rules_fragment = new Page01_RulesFragment();
        page02Game_fragment = new Page02_MainMenuFragment();
        page03ScoreFragment = new Page03_ScoreFragment();

        binding.tabLayut.setupWithViewPager(binding.viewPager);
        MainPage_Fragments_Adapter mainPageAdapter = new MainPage_Fragments_Adapter(getSupportFragmentManager(), 0);

        mainPageAdapter.addFragment(page01Rules_fragment, "Rules");
        mainPageAdapter.addFragment(page02Game_fragment, "Game");
        mainPageAdapter.addFragment(page03ScoreFragment, "Score");

        binding.viewPager.setAdapter(mainPageAdapter);
        binding.viewPager.setCurrentItem(1);
        binding.tabLayut.getTabAt(0).setIcon(R.drawable.rules);
        binding.tabLayut.getTabAt(1).setIcon(R.drawable.game);
        binding.tabLayut.getTabAt(2).setIcon(R.drawable.score);
////////////////////////////////////////////////////////////////////////////////

    }
}