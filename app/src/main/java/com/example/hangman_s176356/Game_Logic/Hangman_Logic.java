package com.example.hangman_s176356.Game_Logic;

import androidx.appcompat.app.AppCompatActivity;
import com.example.hangman_s176356.*;
import com.example.hangman_s176356.End_Game_Body.Lose_Game;
import com.example.hangman_s176356.End_Game_Body.Won_Game;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Hangman_Logic extends AppCompatActivity implements View.OnClickListener {

    private Logic logic = new Logic();

    ImageView imageView;
    TextView textView;
    GridLayout gridLayout;
    Button button;
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman__logic);

        imageView = findViewById(R.id.imageView);
        imageView.setVisibility(View.INVISIBLE);
        textView = findViewById(R.id.gusse);
        gridLayout = findViewById(R.id.gridLayout);
    }

    @Override
    public void onClick(View view) {
        button = findViewById(view.getId());
        int count = 0;
        clickMe(button);
        count ++;
    }

    private void clickMe(Button button){
        String myLetter = (button.getText().toString().toLowerCase());
        logic.gætBogstav(myLetter);
        imageView.setVisibility(View.VISIBLE);
        textView.setText(logic.getSynligtOrd());
        button.setVisibility(View.INVISIBLE);

        switch (logic.getAntalForkerteBogstaver()){
            case 1:
                imageView.setImageResource(R.drawable.galge);
                break;
            case 2:
                imageView.setImageResource(R.drawable.forkert1);
                break;
            case 3:
                imageView.setImageResource(R.drawable.forkert2);
                break;
            case 4:
                imageView.setImageResource(R.drawable.forkert3);
                break;
            case 5:
                imageView.setImageResource(R.drawable.forkert4);
                break;
            case 6:
                imageView.setImageResource(R.drawable.forkert5);
                break;
            case 7:
                imageView.setImageResource(R.drawable.forkert6);
                break;
            default:
                break;
        }
        if (logic.erSpilletVundet()){
            Intent intent = new Intent(Hangman_Logic.this, Won_Game.class);
            startActivity(intent);
            finish();
        }else if (logic.erSpilletTabt()){
            Toast.makeText(getApplicationContext(), "Du er tabt og spillet er slut!", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Hangman_Logic.this, Lose_Game.class);
                    startActivity(intent);
                    finish();
                }
            },2000);
        }
    }
}