package com.nafsoft.aspireacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nafsoft.aspireacademy.examsection.views.ListFragment;

public class MainActivity extends AppCompatActivity {
    private Button examcorner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        examcorner=findViewById(R.id.examCorner);
        examcorner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, ListFragment.class);
                startActivity(intent);
            }
        });
    }
}