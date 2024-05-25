package com.nafsoft.aspireacademy.pdfsection;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;
import com.nafsoft.aspireacademy.R;

public class PDFViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);

        PDFView pdfView = findViewById(R.id.pdfView);

        String pdfUrl = getIntent().getStringExtra("PDF_URL");
        new RetrievePDFStream(pdfView).execute(pdfUrl);
    }
}