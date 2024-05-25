package com.nafsoft.aspireacademy.videosection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;

import com.nafsoft.aspireacademy.R;

public class VideoHome extends AppCompatActivity {

     View classOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_home);
        classOne = findViewById(R.id.videOne);

        classOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VideoHome.this , ShowVideo.class);
                startActivity(i);
            }
        });


    }
}