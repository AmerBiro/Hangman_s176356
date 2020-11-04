package com.example.hangman_s176356.mainpage_fragments;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hangman_s176356.R;
import com.example.hangman_s176356.databinding.FragmentPage01RulesfragmentBinding;

public class Page01_RulesFragment extends Fragment {
    private FragmentPage01RulesfragmentBinding binding;

//    String video_url = "https://youtu.be/leW9ZotUVYo";
//    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPage01RulesfragmentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

/*        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait");
        progressDialog.show();
        Uri uri = Uri.parse(video_url);
        binding.videoView.setVideoURI(uri);
        binding.videoView.start();
        binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                progressDialog.dismiss();
            }
        });*/

        return view;

    }
}