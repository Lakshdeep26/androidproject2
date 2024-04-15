package com.example.project2_lakshdeepkaur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        // Find the "Get Started" button
        Button getStartedButton = findViewById(R.id.buttonstart);

        // Set OnClickListener for the "Get Started" button
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MainActivity when "Get Started" button is clicked
                Intent intent = new Intent(start.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
