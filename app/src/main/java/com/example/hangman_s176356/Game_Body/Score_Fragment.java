package com.example.hangman_s176356.Game_Body;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.hangman_s176356.R;
import java.util.ArrayList;
import java.util.List;

public class Score_Fragment extends Fragment {

    RecyclerView recyclerView;
    List<Player> playerList;
    String playerName[];
    int playerScore[], playerAge[], playerIcon[];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score_, container, false);
        recyclerView = view.findViewById(R.id.rv);

        playerList = new ArrayList<>();
        Player player1 = new Player("Amer", 13, 100, R.drawable.player);
        Player player2 = new Player("Sulaiman", 14, 100, R.drawable.player);
        Player player3 = new Player("Hero", 29, 100, R.drawable.player);
        Player player4 = new Player("Zero", 26, 100, R.drawable.player);
        Player player5 = new Player("Jackson", 15, 100, R.drawable.player);
        Player player6 = new Player("Mario", 7, 100, R.drawable.player);
        Player player7 = new Player("Fire", 13, 100, R.drawable.player);
        Player player8 = new Player("Hire", 8, 100, R.drawable.player);
        Player player9 = new Player("NoWay", 24, 100, R.drawable.player);
        Player player10 = new Player("Sho Sho", 27, 100, R.drawable.player);
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        playerList.add(player5);
        playerList.add(player6);
        playerList.add(player7);
        playerList.add(player8);
        playerList.add(player9);
        playerList.add(player10);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), playerList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        LinearLayoutManager layoutManager
//                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//
//        RecyclerView myList = view.findViewById(R.id.row_Layout);
//        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}