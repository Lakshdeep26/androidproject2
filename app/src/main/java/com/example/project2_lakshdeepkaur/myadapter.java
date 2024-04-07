package com.example.project2_lakshdeepkaur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {


    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder myviewholder, int i, @NonNull model model) {

        myadapter.myviewholder holder = myviewholder;
        holder.Title.setText(model.getTitle());
        holder.Price.setText(model.getPrice());
        holder.Description.setText(model.getDescription());
        Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

      ImageView img;
      TextView Title,Price,Description;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.img1);
            Title=(TextView)itemView.findViewById(R.id.titleText);
            Price=(TextView)itemView.findViewById(R.id.priceText);
            Description=(TextView)itemView.findViewById(R.id.descriptionText);
        }
    }
}
