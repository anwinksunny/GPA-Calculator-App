package com.aetherwave.gpa_c;

import androidx.annotation.NonNull; // Import NonNull
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // Import Log
import android.view.MenuItem; // Import MenuItem
import android.view.View; // Import View
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity"; // Tag for logging

    private TextView tvQuote;
    private ImageButton btnLeftArrow, btnRightArrow;
    private BottomNavigationView bottomNav;
    private String[] quotes;
    private int currentQuoteIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ensure this layout file exists and contains the required IDs
        setContentView(R.layout.activity_profile);

        // --- Initialize Views ---
        tvQuote = findViewById(R.id.tvQuote);
        btnLeftArrow = findViewById(R.id.btnLeftArrow);
        btnRightArrow = findViewById(R.id.btnRightArrow);
        bottomNav = findViewById(R.id.bottom_nav);

        // --- Null Checks for Views ---
        if (tvQuote == null || btnLeftArrow == null || btnRightArrow == null || bottomNav == null) {
            Log.e(TAG, "Error: One or more views not found in activity_profile.xml. Check IDs (tvQuote, btnLeftArrow, btnRightArrow, bottom_nav).");
            // Consider finishing the activity or showing an error if critical views are missing
            // finish();
            // return;
        }

        // --- Setup Bottom Navigation (with if-else if) ---
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.Info); // Set Profile as selected by default

            bottomNav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int itemId = item.getItemId();

                    if (itemId == R.id.Home) {
                        Log.d(TAG, "Home selected. Starting MainActivity.");
                        // NOTE: This now points to MainActivity.class, ensure this is the correct target (e.g., Login screen?)
                        Intent homeIntent = new Intent(ProfileActivity.this, MainActivity.class);
                        // If MainActivity expects any specific extras, add them here.
                        // If navigating back to a main content screen (like MainActivity1 before),
                        // you might need to pass username/password extras again.
                        startActivity(homeIntent);
                        overridePendingTransition(0, 0); // No animation
                        finish(); // Finish ProfileActivity
                        return true; // Handled

                    } else if (itemId == R.id.Info) {
                        Log.d(TAG, "Profile selected (already here).");
                        // You are already in ProfileActivity
                        return true; // Handled (do nothing)
                    }
                    // Add more 'else if' blocks for other menu items if needed

                    return false; // Not handled
                }
            });
        } // End of bottomNav setup

        // --- Initialize Quotes ---
        quotes = new String[]{
                "The expert in anything was once a beginner.",
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "The only way to do great work is to love what you do.",
                "Education is the most powerful weapon which you can use to change the world.",
                "Believe you can and you're halfway there.",
                "Strive not to be a success, but rather to be of value.",
                "The mind is everything. What you think you become."
        };

        // Display initial quote (check if tvQuote is not null)
        if (tvQuote != null && quotes != null && quotes.length > 0) {
            currentQuoteIndex = 0; // Start at the first quote
            tvQuote.setText(quotes[currentQuoteIndex]);
        } else if (tvQuote != null) {
            tvQuote.setText("No quotes available."); // Fallback text
            Log.w(TAG, "Quotes array is null or empty, or tvQuote view is missing.");
        }

        // --- Setup Arrow Button Listeners ---

        // Left Arrow Click Listener
        if (btnLeftArrow != null && tvQuote != null && quotes != null && quotes.length > 0) {
            btnLeftArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Calculate previous index, wrapping around using modulo
                    currentQuoteIndex = (currentQuoteIndex - 1 + quotes.length) % quotes.length;
                    tvQuote.setText(quotes[currentQuoteIndex]);
                    Log.d(TAG, "Left arrow clicked. Displaying quote index: " + currentQuoteIndex);
                }
            });
        } else if (btnLeftArrow != null) {
            btnLeftArrow.setEnabled(false); // Disable button if quotes aren't available
            Log.w(TAG, "Left arrow button disabled - quotes unavailable or TextView missing.");
        }

        // Right Arrow Click Listener
        if (btnRightArrow != null && tvQuote != null && quotes != null && quotes.length > 0) {
            btnRightArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Calculate next index, wrapping around using modulo
                    currentQuoteIndex = (currentQuoteIndex + 1) % quotes.length;
                    tvQuote.setText(quotes[currentQuoteIndex]);
                    Log.d(TAG, "Right arrow clicked. Displaying quote index: " + currentQuoteIndex);
                }
            });
        } else if (btnRightArrow != null) {
            btnRightArrow.setEnabled(false); // Disable button if quotes aren't available
            Log.w(TAG, "Right arrow button disabled - quotes unavailable or TextView missing.");
        }
    }
}