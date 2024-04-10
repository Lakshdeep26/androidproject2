package com.example.project2_lakshdeepkaur;

import android.os.Bundle;

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