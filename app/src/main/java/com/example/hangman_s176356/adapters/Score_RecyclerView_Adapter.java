package com.example.hangman_s176356.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hangman_s176356.R;
import com.example.hangman_s176356.childpages.Page03_3_ChildScore;
import com.example.hangman_s176356.databinding.FragmentGameBinding;
import com.example.hangman_s176356.logic.Player;

import java.util.List;

public class Score_RecyclerView_Adapter extends RecyclerView.Adapter<Score_RecyclerView_Adapter.MyViewHolderAdapter> {

    Context context;
     List<Player> playerList;

    public Score_RecyclerView_Adapter(Context context, List<Player> player) {
        this.context = context;
        this.playerList = player;
    }

//    String playerName[];
//    int images[], playerAge[], playerScore[];
//    public RecyclerViewAdapter(Context context, String playerName[], int playerAge[], int playerScore[], int images[]) {
//        this.context = context;
//        this.playerName = playerName;
//        this.playerAge = playerAge;
//        this.playerScore = playerScore;
//        this.images = images;
//    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderAdapter holder, final int position) {
        final Player player = playerList.get(position);
        holder.playerName.setText(player.getPlayerName());
        holder.playerScore.setText(""+ player.getPlayerScore());
        holder.playerAge.setText(""+ player.getPlayerAge());
        holder.playerIcon.setImageResource(player.getPlayerIcon());

        holder.row_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Page03_3_ChildScore.class);
                intent.putExtra("childPlayerIcon", player.getPlayerIcon());
                intent.putExtra("childPlayerScore", player.getPlayerScore());
                intent.putExtra("childPlayerAge", player.getPlayerAge());
                intent.putExtra("childPlayerName", player.getPlayerName());
                context.startActivity(intent);
            }
        });
//        holder.playerScore.setText("" + playerScore[position]);
//        holder.playerAge.setText("" + playerAge[position]);
//        holder.playerName.setText(playerName[position]);
//        holder.playerIcon.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    @NonNull
    @Override
    public MyViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.rows, parent, false);
        return new MyViewHolderAdapter(view);
    }

    public class MyViewHolderAdapter extends RecyclerView.ViewHolder {
        TextView playerScore, playerAge, playerName;
        ImageView playerIcon;
        ConstraintLayout row_Layout;

        public MyViewHolderAdapter(@NonNull View itemView) {
            super(itemView);

            playerScore = itemView.findViewById(R.id.playerScore);
            playerAge = itemView.findViewById(R.id.playerAge);
            playerName = itemView.findViewById(R.id.playerName);
            playerIcon = itemView.findViewById(R.id.playerIcon);
            row_Layout = itemView.findViewById(R.id.row_Layout);
        }
    }
}
