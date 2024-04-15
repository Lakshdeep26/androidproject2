package com.example.project2_lakshdeepkaur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class homeproductspage extends AppCompatActivity {
 RecyclerView recView;
 myadapter adapter;
    FirebaseDatabase database;
    //FireBaseA

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homeproductspage);
        database = FirebaseDatabase.getInstance();

        recView = (RecyclerView) findViewById(R.id.recView);
        recView.setLayoutManager(new LinearLayoutManager(this));
        //test
        ImageView cartImageView = findViewById(R.id.cartImageView);
        cartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event, navigate to cart page
                Intent intent = new Intent(homeproductspage.this, CartActivity.class);
                startActivity(intent);
            }
        });
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Products"), model.class)
                        .build();

        adapter = new myadapter(options,this);
        recView.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}