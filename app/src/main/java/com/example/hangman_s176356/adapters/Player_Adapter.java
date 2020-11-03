package com.example.hangman_s176356.adapters;
import com.example.hangman_s176356.R;
import com.example.hangman_s176356.player.UpdatePlayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Player_Adapter extends RecyclerView.Adapter<Player_Adapter.MyViewHolder> {
    private Context context;
    private Activity activity;
    private ArrayList playerId, playerName, playerBirthDate, playerScore;

    public Player_Adapter(Activity activity, Context context, ArrayList playerId, ArrayList playerName, ArrayList playerBirthDate,
                          ArrayList playerScore){
        this.activity = activity;
        this.context = context;
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerBirthDate = playerBirthDate;
        this.playerScore = playerScore;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.player_adapter_player_list, parent, false);

        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.playerId.setText(String.valueOf(playerId.get(position)));
        holder.playerName.setText(String.valueOf(playerName.get(position)));
        holder.playerBirthDate.setText(String.valueOf(playerBirthDate.get(position)));
        holder.playerScore.setText(String.valueOf(playerScore.get(position)));
        //Recyclerview onClickListener
        holder.player_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdatePlayer.class);
                intent.putExtra("playerId", String.valueOf(playerId.get(position)));
                intent.putExtra("playerName", String.valueOf(playerName.get(position)));
                intent.putExtra("playerBirthDate", String.valueOf(playerBirthDate.get(position)));
                intent.putExtra("playerScore", String.valueOf(playerScore.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });




    }

    @Override
    public int getItemCount() {
        return playerId.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView  playerId, playerName, playerBirthDate, playerScore;
        LinearLayout player_Layout;

        private Activity binding;



        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            playerId = itemView.findViewById(R.id.playerId);
            playerName = itemView.findViewById(R.id.playerName);
            playerBirthDate = itemView.findViewById(R.id.playerBirthDate);
            playerScore = itemView.findViewById(R.id.playerScore);
            player_Layout = itemView.findViewById(R.id.player_Layout);
            //Animate Recyclerview
            Animation recyclerview_anim = AnimationUtils.loadAnimation(context, R.anim.recyclerview_anim);
            player_Layout.setAnimation(recyclerview_anim);
        }

    }

}
