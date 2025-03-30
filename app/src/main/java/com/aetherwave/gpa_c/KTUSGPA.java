package com.aetherwave.gpa_c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;


public class KTUSGPA extends AppCompatActivity {

    private Button btnComputerScience, btnCivil, btnAI, btnMechanical, btnECE, btnEEE;
    private ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ktusgpa);

        btnComputerScience = findViewById(R.id.btn_computer_science);
        btnCivil = findViewById(R.id.btn_civil);
        btnAI = findViewById(R.id.btn_ai);
        btnMechanical = findViewById(R.id.btn_mechanical);
        btnECE = findViewById(R.id.btn_ece);
        btnEEE = findViewById(R.id.btn_eee);
        btnback = findViewById(R.id.btn_back);

        View.OnClickListener listenercs = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SemestersActivity
                Intent intent = new Intent(KTUSGPA.this, csSemestersActivity.class);
                startActivity(intent);
            }
        };
        View.OnClickListener listenercivil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SemestersActivity
                Intent intent = new Intent(KTUSGPA.this, civilSemestersActivity.class);
                startActivity(intent);
            }
        };
        View.OnClickListener listenerai = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SemestersActivity
                Intent intent = new Intent(KTUSGPA.this, aiSemestersActivity.class);
                startActivity(intent);
            }
        };
        View.OnClickListener listenermechanical = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SemestersActivity
                Intent intent = new Intent(KTUSGPA.this, mechanicalSemestersActivity.class);
                startActivity(intent);
            }
        };
        View.OnClickListener listenerece = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SemestersActivity
                Intent intent = new Intent(KTUSGPA.this, eceSemestersActivity.class);
                startActivity(intent);
            }
        };
        View.OnClickListener listenereee = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SemestersActivity
                Intent intent = new Intent(KTUSGPA.this, eeeSemestersActivity.class);
                startActivity(intent);
            }
        };
        View.OnClickListener listenerback = new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // Simulate the back button press
                getOnBackPressedDispatcher().onBackPressed();
            }
        };



        btnComputerScience.setOnClickListener(listenercs);
        btnCivil.setOnClickListener(listenercivil);
        btnAI.setOnClickListener(listenerai);
        btnMechanical.setOnClickListener(listenermechanical);
        btnECE.setOnClickListener(listenerece);
        btnEEE.setOnClickListener(listenereee);
        btnback.setOnClickListener(listenerback);
    }
}