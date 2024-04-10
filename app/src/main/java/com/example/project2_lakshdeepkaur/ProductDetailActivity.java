package com.example.project2_lakshdeepkaur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singlerow);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String price = intent.getStringExtra("price");
        String description = intent.getStringExtra("description");
        String purl = intent.getStringExtra("purl");

        // Display the data in the UI elements
        TextView titleText = findViewById(R.id.titleText);
        TextView priceText = findViewById(R.id.priceText);
        TextView descriptionText = findViewById(R.id.descriptionText);
        ImageView imageView = findViewById(R.id.img1);

        titleText.setText(title);
        priceText.setText(price);
        descriptionText.setText(description);
        Glide.with(this).load(purl).into(imageView);


    }
}
