package com.example.hangman_s176356.player;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.hangman_s176356.R;
import com.example.hangman_s176356.game.HangmanGame;
import com.example.hangman_s176356.databinding.PlayerCreatePlayerBinding;
import com.example.hangman_s176356.logic.DatePicker;
import com.example.hangman_s176356.database.Player;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

public class CreatePlayer extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private PlayerCreatePlayerBinding binding;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_create_player);

        binding = PlayerCreatePlayerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.playerBirthDate.setClickable(false);
        binding.playerScore.setEnabled(false);
        binding.playerScore.setText("100");
        binding.createPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (
                        TextUtils.isEmpty(binding.playerName.getText().toString()) ||
                                TextUtils.isEmpty(binding.playerBirthDate.getText().toString()) ||
                                TextUtils.isEmpty(binding.playerScore.getText().toString())){
                    Toast.makeText(CreatePlayer.this, "You must fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Player myDB = new Player(CreatePlayer.this);
                    myDB.createPlayer(binding.playerName.getText().toString().trim(),
                    binding.playerBirthDate.getText().toString().trim(),
                    Integer.valueOf(binding.playerScore.getText().toString().trim()));

                    Intent intent = new Intent(CreatePlayer.this, HangmanGame.class);
                    intent.putExtra("playerName", String.valueOf(binding.playerName.getText().toString()));
                    intent.putExtra("playerScore", String.valueOf(binding.playerScore.getText().toString()));
                    startActivityForResult(intent, 1);

                    startActivity(intent);
                    finish();
                }
            }
        });

        binding.playerScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gallery, "select picture"), PICK_IMAGE);
            }
        });

        binding.playerBirthDate.setInputType(InputType.TYPE_NULL);
        binding.playerBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new DatePicker();
                dialogFragment.show(getSupportFragmentManager(), "date picker");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK ) {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                binding.playerImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onDateSet(android.widget.DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, i);
        calendar.set(Calendar.MONTH, i1);
        calendar.set(Calendar.DAY_OF_MONTH, i2);
        String birthDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        binding.playerBirthDate.setText(birthDate);
    }
}
