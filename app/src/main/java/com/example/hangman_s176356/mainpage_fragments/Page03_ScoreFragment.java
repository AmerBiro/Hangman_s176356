package com.example.hangman_s176356.mainpage_fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import com.example.hangman_s176356.MainPage;
import com.example.hangman_s176356.R;
import com.example.hangman_s176356.adapters.Player_Adapter;
import com.example.hangman_s176356.databinding.FragmentPage03ScorefragmentBinding;
import com.example.hangman_s176356.database.Player;

import java.util.ArrayList;


public class Page03_ScoreFragment extends Fragment {
    private FragmentPage03ScorefragmentBinding binding;

    Player myDB;
    ArrayList<String> playerId, playerName, playerBirthDate, playerScore;
    Player_Adapter playerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPage03ScorefragmentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();



        myDB = new Player(getActivity());
        playerId = new ArrayList<>();
        playerName = new ArrayList<>();
        playerBirthDate = new ArrayList<>();
        playerScore = new ArrayList<>();

        storeDataInArrays();

        playerAdapter = new Player_Adapter(getActivity(),getContext(), playerId, playerName, playerBirthDate,
                playerScore);
        binding.scoreRecyclerView.setAdapter(playerAdapter);
        binding.scoreRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            getActivity().recreate();
        }
    }


    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            binding.emptyImageview.setVisibility(View.VISIBLE);
            binding.noData.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                playerId.add(cursor.getString(0));
                playerName.add(cursor.getString(1));
                playerBirthDate.add(cursor.getString(2));
                playerScore.add(cursor.getString(3));
            }
            binding.emptyImageview.setVisibility(View.GONE);
            binding.noData.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.delete_all){
            confirmDialog();
            return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Data?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Player myDB = new Player(getActivity());
                myDB.deleteAllData();
                //Refresh Activity
                Intent intent = new Intent(getActivity(), MainPage.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}