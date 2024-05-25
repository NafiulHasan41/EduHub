package com.nafsoft.aspireacademy.pdfsection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nafsoft.aspireacademy.R;

public class pdfSection extends AppCompatActivity {

    Button fetch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_section);
        fetch=findViewById(R.id.notebtn);

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pdfSection.this,recyclerViewActivity.class));
            }
        });
    }
}