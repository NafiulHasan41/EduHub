package com.nafsoft.aspireacademy.pdfsection;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.nafsoft.aspireacademy.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class pdfSection extends AppCompatActivity implements PdfAdapter.OnPdfClickListener{
    private RecyclerView recyclerView;
    private PdfAdapter pdfAdapter;
    private List<File> pdfFiles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_section);

        recyclerView = findViewById(R.id.pdfRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pdfFiles = new ArrayList<>();
        pdfAdapter = new PdfAdapter(this, pdfFiles, this);
        recyclerView.setAdapter(pdfAdapter);

        fetchPdfsFromFirebase();
    }

    private void fetchPdfsFromFirebase() {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("pdfSection");
        storageReference.listAll().addOnSuccessListener(listResult -> {
            for (StorageReference item : listResult.getItems()) {
                item.getDownloadUrl().addOnSuccessListener(uri -> {
                    File localFile = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), item.getName());
                    item.getFile(localFile).addOnSuccessListener(taskSnapshot -> {
                        pdfFiles.add(localFile);
                        pdfAdapter.notifyDataSetChanged();
                    }).addOnFailureListener(e -> Log.e("pdfSection", "Failed to download file", e));
                });
            }
        }).addOnFailureListener(e -> Toast.makeText(pdfSection.this, "Failed to fetch PDFs", Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onPdfClick(File file) {

        Context context=null;
        // Implement download logic
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.fromFile(file);

        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, file.getName());
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        // Enqueue the download request



        if (downloadManager != null) {
            downloadManager.enqueue(request);
            Toast.makeText(context, "Downloading " + file.getName(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Failed to initiate download", Toast.LENGTH_SHORT).show();
        }
    }

}
