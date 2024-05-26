package com.nafsoft.aspireacademy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nafsoft.aspireacademy.examsection.views.ExamHome;
import com.nafsoft.aspireacademy.pdfsection.recyclerViewActivity;
import com.nafsoft.aspireacademy.videosection.VideoHome;

public class CourseDetails extends AppCompatActivity {

    CardView video , exam , pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        video = findViewById(R.id.videoCard);
        exam = findViewById(R.id.examCard);
        pdf = findViewById(R.id.pdfCard);

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CourseDetails.this , VideoHome.class);
                startActivity(i);
            }
        });
        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CourseDetails.this , ExamHome.class);
                startActivity(i);
            }
        });

        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CourseDetails.this , recyclerViewActivity.class);
                startActivity(i);
            }
        });
    }
}