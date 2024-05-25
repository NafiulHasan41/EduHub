package com.nafsoft.aspireacademy.videosection;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.nafsoft.aspireacademy.R;

public class ShowVideo extends AppCompatActivity {

    VideoView showVideo;
  MediaController mediaController;

  String url1 = "https://firebasestorage.googleapis.com/v0/b/aspireacademy-software-project.appspot.com/o/Videos%2FintegrationClass1.mp4?alt=media&token=adab9072-9f59-4456-9b2f-8d5fed25f7fb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);

        showVideo = findViewById(R.id.videoView);


        Uri uri = Uri.parse(url1);

        showVideo.setVideoURI(uri);

        mediaController = new MediaController(this);

        mediaController.setMediaPlayer(showVideo);

        showVideo.setMediaController(mediaController);
        showVideo.requestFocus();

        showVideo.start();



    }
}