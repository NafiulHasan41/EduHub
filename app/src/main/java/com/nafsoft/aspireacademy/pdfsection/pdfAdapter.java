package com.nafsoft.aspireacademy.pdfsection;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.nafsoft.aspireacademy.R;

import java.io.File;
import java.util.ArrayList;

public class pdfAdapter extends RecyclerView.Adapter<pdfAdapter.ViewHolder> {

    RecyclerView  recyclerView;
    Context context;
    ArrayList<String> items=new ArrayList<>();
    ArrayList<String> urls=new ArrayList<>();
    FirebaseStorage storage;

    public pdfAdapter(RecyclerView recyclerView, Context context, ArrayList<String> items, ArrayList<String> urls) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.items = items;
        this.urls = urls;
        this.storage = FirebaseStorage.getInstance(); // Initialize Firebase Storage
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //to create views for recycler views item

        View view= LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //initialise the elements of individual items
        holder.nameOfFile.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        //Return the number of items

        return items.size();
    }

    public void update(String fileName, String url) {

        items.add(fileName);
        urls.add(url);
        notifyDataSetChanged();     //refreshesh the recycler view auromatically
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameOfFile;
        public ViewHolder(View itemView) {  //Represents indv list items
            super(itemView);
            nameOfFile=itemView.findViewById(R.id.pdftext);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position=getAbsoluteAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION)
                    {
                        openPDF(urls.get(position));
                    }
 ///                   int position=recyclerView.getChildLayoutPosition(v);
//                    Intent intent=new Intent();
//                    intent.setType(Intent.ACTION_VIEW);     //denotes that we are going to view something
//                    intent.setData(Uri.parse(urls.get(position)));
//                    context.startActivity(intent);
                }
            });
        }
    }

    private void openPDF(String url) {
        Intent intent = new Intent(context, PDFViewerActivity.class);
        intent.putExtra("PDF_URL", url);
        context.startActivity(intent);
    }

}


