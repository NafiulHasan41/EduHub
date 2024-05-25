package com.nafsoft.aspireacademy.pdfsection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nafsoft.aspireacademy.R;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.PdfViewHolder> {

    private Context context;
    private List<File> pdfFiles;
    private OnPdfClickListener listener;

    public interface OnPdfClickListener {
        void onPdfClick(File file);
    }


    public PdfAdapter(Context context, List<File> pdfFiles, OnPdfClickListener listener) {
        this.context = context;
        this.pdfFiles = pdfFiles;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PdfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pdf_list_item, parent, false);
        return new PdfViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PdfViewHolder holder, int position) {
        File file = pdfFiles.get(position);
        holder.pdfTitle.setText(file.getName());
        holder.itemView.setOnClickListener(v -> listener.onPdfClick(file));
    }
    @Override
    public int getItemCount() {
        return pdfFiles.size();
    }

    public static class PdfViewHolder extends RecyclerView.ViewHolder {
        ImageView pdfThumbnail;
        TextView pdfTitle;

        public PdfViewHolder(@NonNull View itemView) {
            super(itemView);
            pdfThumbnail = itemView.findViewById(R.id.pdfThumbnail);
            pdfTitle = itemView.findViewById(R.id.pdfTitle);
        }
    }


}
