
package com.example.project2_lakshdeepkaur;
import android.content.Intent;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.project2_lakshdeepkaur.R;

public class ProductDetailActivity extends AppCompatActivity {

    TextView titleText, priceText, descriptionText, quantityText;
    Button addToCartButton, decrementButton, incrementButton, gotoCartButton;
    ImageView imageView;
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_activity);

        // Initialize UI elements
        titleText = findViewById(R.id.titleText);
        priceText = findViewById(R.id.priceText);
        descriptionText = findViewById(R.id.descriptionText);
        quantityText = findViewById(R.id.quantityText);
        addToCartButton = findViewById(R.id.addToCartButton);
        decrementButton = findViewById(R.id.minusButton);
        incrementButton = findViewById(R.id.plusButton);
        imageView = findViewById(R.id.img1);
        gotoCartButton = findViewById(R.id.gotoCart);

        // Get data from intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String price = intent.getStringExtra("price");
        String description = intent.getStringExtra("description");
        String purl = intent.getStringExtra("purl");

        // Display the data in the UI elements
        titleText.setText(title);
        priceText.setText(price);
        descriptionText.setText(description);
        Glide.with(this).load(purl).into(imageView);

        // Set click listener for add to cart button
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display message indicating item has been added to cart
                Toast.makeText(ProductDetailActivity.this, "Item added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        // Set click listeners for quantity adjustment buttons
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity();
            }
        });

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity();
            }
        });

        // Set click listener for go to cart button
        gotoCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to cart activity
                Intent cartIntent = new Intent(ProductDetailActivity.this, CartActivity.class);
                startActivity(cartIntent);
            }
        });
    }

    // Method to increment quantity
    private void incrementQuantity() {
        quantity++;
        quantityText.setText(String.valueOf(quantity));
    }

    // Method to decrement quantity
    private void decrementQuantity() {
        if (quantity > 1) {
            quantity--;
            quantityText.setText(String.valueOf(quantity));
        }
    }
}
