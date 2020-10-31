package com.example.hangman_s176356.childpages;

import androidx.appcompat.app.AppCompatActivity;
import com.example.hangman_s176356.*;
import com.example.hangman_s176356.databinding.ActivityHangmanLogicBinding;
import com.example.hangman_s176356.endgame.animation.Lose;
import com.example.hangman_s176356.endgame.animation.Won;
import com.example.hangman_s176356.logic.Logic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Page02_2_ChildGame extends AppCompatActivity implements View.OnClickListener {
    private ActivityHangmanLogicBinding binding;
    private Logic logic = new Logic();

    Button button;
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman__logic);

        binding = ActivityHangmanLogicBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.imageView.setVisibility(View.INVISIBLE);
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
        binding.imageView.setVisibility(View.VISIBLE);
        binding.gusse.setText(logic.getSynligtOrd());
        button.setVisibility(View.INVISIBLE);

        switch (logic.getAntalForkerteBogstaver()){
            case 1:
                binding.imageView.setImageResource(R.drawable.galge);
                break;
            case 2:
                binding.imageView.setImageResource(R.drawable.forkert1);
                break;
            case 3:
                binding.imageView.setImageResource(R.drawable.forkert2);
                break;
            case 4:
                binding.imageView.setImageResource(R.drawable.forkert3);
                break;
            case 5:
                binding.imageView.setImageResource(R.drawable.forkert4);
                break;
            case 6:
                binding.imageView.setImageResource(R.drawable.forkert5);
                break;
            case 7:
                binding.imageView.setImageResource(R.drawable.forkert6);
                break;
            default:
                break;
        }
        if (logic.erSpilletVundet()){
            Intent intent = new Intent(Page02_2_ChildGame.this, Won.class);
            startActivity(intent);
            finish();
        }else if (logic.erSpilletTabt()){
            Toast.makeText(getApplicationContext(), "Du er tabt og spillet er slut!", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Page02_2_ChildGame.this, Lose.class);
                    startActivity(intent);
                    finish();
                }
            },2000);
        }
    }
}