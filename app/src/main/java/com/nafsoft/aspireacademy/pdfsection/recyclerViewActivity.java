package com.nafsoft.aspireacademy.pdfsection;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.nafsoft.aspireacademy.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private pdfAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new pdfAdapter(recyclerView, this, new ArrayList<>(), new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Fetch PDF files from Firebase Storage
        fetchPDFFiles();
    }

    private void fetchPDFFiles() {
        // List of file names and URLs (replace this with your actual logic)
        List<String> fileNames = Arrays.asList("A2_Test2.pdf", "ece-lab-04.pdf","CSE 3120 lab-02.pdf");
        List<String> urls = Arrays.asList("https://firebasestorage.googleapis.com/v0/b/aspireacademy-software-project.appspot.com/o/pdfSection%2FA2_Test2.pdf?alt=media&token=65d11d27-4d15-4017-b55c-7c8fdcb3178e"
                ,"https://firebasestorage.googleapis.com/v0/b/aspireacademy-software-project.appspot.com/o/pdfSection%2Fece-lab-04.pdf?alt=media&token=2b336e73-9b17-4bc4-8c14-3806a983d745"
                   ,"https://firebasestorage.googleapis.com/v0/b/aspireacademy-software-project.appspot.com/o/pdfSection%2FCSE%203120%20lab-02.pdf?alt=media&token=bf2a520e-50d5-4a6a-a06f-f1868d7dcc7a"
                    );

        // Download each PDF file from Firebase Storage
        for (int i = 0; i < fileNames.size(); i++) {
            String fileName = fileNames.get(i);
            String url = urls.get(i);

            // Create a StorageReference to the PDF file in Firebase Storage
            StorageReference storageRef = FirebaseStorage.getInstance().getReference().child("pdfSection").child(fileName);

            // Download the PDF file
            try {
                File localFile = File.createTempFile("temp_pdf", "pdf");
                storageRef.getFile(localFile).addOnSuccessListener(taskSnapshot -> {
                    // Add the downloaded PDF file to the RecyclerView adapter
                    adapter.update(fileName, localFile.getAbsolutePath());
                }).addOnFailureListener(e -> {
                    // Handle any errors that may occur during the download process
                    Toast.makeText(this, "Failed to download PDF: " + fileName, Toast.LENGTH_SHORT).show();
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
