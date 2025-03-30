package com.aetherwave.gpa_c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class aiSemestersActivity extends AppCompatActivity {

    private Button btnSemester1, btnSemester2, btnSemester3, btnSemester4, btnSemester5, btnSemester6, btnSemester7, btnSemester8;
    private ImageButton btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aisemesters);

        btnSemester1 = findViewById(R.id.btn_semester1);
        btnSemester2 = findViewById(R.id.btn_semester2);
        btnSemester3 = findViewById(R.id.btn_semester3);
        btnSemester4 = findViewById(R.id.btn_semester4);
        btnSemester5 = findViewById(R.id.btn_semester5);
        btnSemester6 = findViewById(R.id.btn_semester6);
        btnSemester7 = findViewById(R.id.btn_semester7);
        btnSemester8 = findViewById(R.id.btn_semester8);
        btnback= findViewById(R.id.btn_back);

        btnSemester1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aiSemestersActivity.this, Semester1DetailsActivity.class);
                startActivity(intent);
            }
        });
        btnSemester2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aiSemestersActivity.this, Semester2DetailsActivity.class);
                startActivity(intent);
            }
        });
        btnSemester3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aiSemestersActivity.this, aiSemester3DetailsActivity.class);
                startActivity(intent);
            }
        });
        btnSemester4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aiSemestersActivity.this, aiSemester4DetailsActivity.class);
                startActivity(intent);
            }
        });
        btnSemester5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aiSemestersActivity.this, aiSemester5DetailsActivity.class);
                startActivity(intent);
            }
        });
        btnSemester6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aiSemestersActivity.this, aiSemester6DetailsActivity.class);
                startActivity(intent);
            }
        });
        btnSemester7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aiSemestersActivity.this, aiSemester7DetailsActivity.class);
                startActivity(intent);
            }
        });
        btnSemester8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aiSemestersActivity.this, aiSemester8DetailsActivity.class);
                startActivity(intent);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // Simulate the back button press
                getOnBackPressedDispatcher().onBackPressed();
            }
        });

    }
}
