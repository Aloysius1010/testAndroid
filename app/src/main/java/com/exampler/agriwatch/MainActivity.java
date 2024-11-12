package com.exampler.agriwatch;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button playMusic;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.song);

        playMusic = findViewById(R.id.music_btn);

        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    pauseMusic();
                }
                else {
                    startMusic();
                }
            }
        });


    }
    public void pauseMusic(){
        if(mediaPlayer !=null){
            mediaPlayer.pause();
            playMusic.setText("Play");
        }
    }
    public void startMusic(){
        if(mediaPlayer !=null) {
            mediaPlayer.start();
            playMusic.setText("Pause");
        }

    }
}