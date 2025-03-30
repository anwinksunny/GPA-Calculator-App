package com.aetherwave.gpa_c;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // Import Log for better error reporting
import android.view.MenuItem; // Import MenuItem
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull; // Import NonNull
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; // Tag for logging



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ensure this layout file exists and contains all the required IDs
        setContentView(R.layout.activity_main);

        // --- Initialize Bottom Navigation ---
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);

        // Check if bottomNav was found
        if (bottomNav == null) {
            Log.e(TAG, "Error: BottomNavigationView with ID 'bottom_nav' not found in layout activity_main.xml");
            // Depending on your app's needs, you might want to return or throw an exception here
            // return; // Exit onCreate if the critical nav view is missing
        } else {
            // Set Home as the default selected item
            bottomNav.setSelectedItemId(R.id.Home);

            // Set the listener using if-else if
            bottomNav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int itemId = item.getItemId(); // Get the ID once

                    if (itemId == R.id.Home) {
                        // Already in MainActivity1 (Home), do nothing or maybe refresh
                        Log.d(TAG, "Home selected (already here).");
                        return true; // Indicate event was handled

                    } else if (itemId == R.id.Info) {
                        Log.d(TAG, "Profile selected. Starting ProfileActivity.");
                        Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);


                        startActivity(profileIntent);
                        overridePendingTransition(0, 0); // No animation
                        finish(); // Close MainActivity1 as per original logic
                        return true; // Indicate event was handled

                    }
                    // Add more 'else if (itemId == R.id.some_other_id)' blocks here
                    // for other menu items if you have them

                    return false; // Indicate event was not handled if no match
                }
            });
        } // End of bottomNav initialization block


        // --- Initialize Buttons ---
        Button ktuButton = findViewById(R.id.button);
        Button universalButton = findViewById(R.id.button2);

        // Set click listener for KTU SGPA Calculator button
        if (ktuButton != null) {
            ktuButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "KTU button clicked. Starting KTUSGPA Activity.");
                    Intent intent = new Intent(MainActivity.this, KTUSGPA.class);
                    startActivity(intent);
                }
            });
        } else {
            Log.e(TAG, "Error: Button with ID 'button' not found in layout activity_main.xml");
        }

        // Set click listener for Universal SGPA Calculator button
        if (universalButton != null) {
            universalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Universal button clicked. Starting universalsgpa Activity.");
                    // Ensure the class name 'universalsgpa' is correct (Java convention is UpperCamelCase like 'UniversalSgpaActivity')
                    Intent intent = new Intent(MainActivity.this, universalsgpa.class);
                    startActivity(intent);
                }
            });
        } else {
            Log.e(TAG, "Error: Button with ID 'button2' not found in layout activity_main.xml");
        }
    }
}