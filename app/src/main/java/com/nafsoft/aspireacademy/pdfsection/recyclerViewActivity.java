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

    //The recyclerViewActivity class fetches PDF files from the data source (e.g., Firebase Storage).
    //The pdfAdapter instances are the observers.
    //The recyclerViewActivity class acts as the subject or observable.

    private void fetchPDFFiles() {
        // List of file names and URLs (replace this with your actual logic)
        List<String> fileNames = Arrays.asList("A2_Test2.pdf", "ece-lab-04.pdf","CSE 3120 lab-02.pdf","ECE-5.pdf","Turing Machine.pdf","Finite State Machine.pdf","Regular Expression.pdf");

        List<String> urls = Arrays.asList("https://firebasestorage.googleapis.com/v0/b/aspireacademy-software-project.appspot.com/o/pdfSection%2FA2_Test2.pdf?alt=media&token=65d11d27-4d15-4017-b55c-7c8fdcb3178e"
                ,"https://firebasestorage.googleapis.com/v0/b/aspireacademy-software-project.appspot.com/o/pdfSection%2Fece-lab-04.pdf?alt=media&token=2b336e73-9b17-4bc4-8c14-3806a983d745"
                   ,"https://firebasestorage.googleapis.com/v0/b/aspireacademy-software-project.appspot.com/o/pdfSection%2FCSE%203120%20lab-02.pdf?alt=media&token=bf2a520e-50d5-4a6a-a06f-f1868d7dcc7a"
                    ,"https://firebasestorage.googleapis.com/v0/b/aspireacademy-software-project.appspot.com/o/pdfSection%2FECE-5.pdf?alt=media&token=c3b844c8-3d12-4c28-ae4a-4640343eb2b3"
                    ,"https://firebasestorage.googleapis.com/v0/b/aspireacademy-software-project.appspot.com/o/pdfSection%2FTuring%20Machine.pdf?alt=media&token=4a5953a6-9909-41e4-b7c6-6b32e35f64b4"
                   ,"https://firebasestorage.googleapis.com/v0/b/aspireacademy-software-project.appspot.com/o/pdfSection%2FFinite%20State%20Machine.pdf?alt=media&token=c0919fa3-eb2e-41bc-b221-99db9bd8545b"
                    ,"https://firebasestorage.googleapis.com/v0/b/aspireacademy-software-project.appspot.com/o/pdfSection%2FRegular%20Expression.pdf?alt=media&token=6c223004-7d9b-44f0-93e1-bdfdf2c97710");



        // Download each PDF file from Firebase Storage
        for (int i = 0; i < fileNames.size(); i++) {
            String fileName = fileNames.get(i);
            String url = urls.get(i);

            adapter.update(fileName, url);
        }
    }
    //observer pattern

}
