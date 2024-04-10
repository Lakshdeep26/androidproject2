package com.example.project2_lakshdeepkaur;

import android.content.Context;
import android.content.Intent;
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

public class myadapter extends FirebaseRecyclerAdapter<model, myadapter.myviewholder> {

    private Context context;

    public myadapter(@NonNull FirebaseRecyclerOptions<model> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.bind(model);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;
        TextView Title, Price, Description;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            Title = itemView.findViewById(R.id.titleText);
            Price = itemView.findViewById(R.id.priceText);
            Description = itemView.findViewById(R.id.descriptionText);

            // Set click listener
            itemView.setOnClickListener(this);
        }

        public void bind(model model) {
            Title.setText(model.getTitle());
            Price.setText(model.getPrice());
            Description.setText(model.getDescription());
            Glide.with(context).load(model.getPurl()).into(img);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                model clickedItem = getItem(position);
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("title", clickedItem.getTitle());
                intent.putExtra("price", clickedItem.getPrice());
                intent.putExtra("description", clickedItem.getDescription());
                intent.putExtra("purl", clickedItem.getPurl());
                context.startActivity(intent);
            }
        }
    }
}
