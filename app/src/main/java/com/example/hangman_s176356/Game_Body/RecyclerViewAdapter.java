package com.example.hangman_s176356.Game_Body;

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
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolderAdapter> {

    Context context;
     List<Player> playerList;

    public RecyclerViewAdapter(Context context, List<Player> player) {
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

    @NonNull
    @Override
    public MyViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.rows, parent, false);
        return new MyViewHolderAdapter(view);
    }

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
                Intent intent = new Intent(context, ChildPlayerView.class);
                intent.putExtra("childPlayerIcon", player.playerIcon);
                intent.putExtra("childPlayerScore", player.playerScore);
                intent.putExtra("childPlayerAge", player.playerAge);
                intent.putExtra("childPlayerName", player.playerName);
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
