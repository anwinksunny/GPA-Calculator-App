package com.aetherwave.gpa_c;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class civilSemester6DetailsActivity extends AppCompatActivity {

    private Spinner spinnerGrade1, spinnerGrade2, spinnerGrade3, spinnerGrade4, spinnerGrade5, spinnerGrade6, spinnerGrade7, spinnerGrade8;
    private TextView tvSGPAResult;
    private Button btnClear, btnCalculateSGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civilsemester6_details);

        spinnerGrade1 = findViewById(R.id.spinner_grade_1);
        spinnerGrade2 = findViewById(R.id.spinner_grade_2);
        spinnerGrade3 = findViewById(R.id.spinner_grade_3);
        spinnerGrade4 = findViewById(R.id.spinner_grade_4);
        spinnerGrade5 = findViewById(R.id.spinner_grade_5);
        spinnerGrade6 = findViewById(R.id.spinner_grade_6);
        spinnerGrade7 = findViewById(R.id.spinner_grade_7);
        spinnerGrade8 = findViewById(R.id.spinner_grade_8);
        tvSGPAResult = findViewById(R.id.tv_sgpa_result);
        btnClear = findViewById(R.id.btn_clear);
        btnCalculateSGPA = findViewById(R.id.btn_calculate_sgpa);

        // Initialize ArrayAdapter for grades
        ArrayAdapter<CharSequence> gradeAdapter = ArrayAdapter.createFromResource(this,
                R.array.grades_array, android.R.layout.simple_spinner_item);
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set adapters to spinners
        spinnerGrade1.setAdapter(gradeAdapter);
        spinnerGrade2.setAdapter(gradeAdapter);
        spinnerGrade3.setAdapter(gradeAdapter);
        spinnerGrade4.setAdapter(gradeAdapter);
        spinnerGrade5.setAdapter(gradeAdapter);
        spinnerGrade6.setAdapter(gradeAdapter);
        spinnerGrade7.setAdapter(gradeAdapter);
        spinnerGrade8.setAdapter(gradeAdapter);
        // Set click listener to clear button
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearGrades();
            }
        });

        btnCalculateSGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (areAllGradesSelected()) {
                    calculateSGPA();
                    ScrollView scrollView = findViewById(R.id.scrollView); // replace R.id.scrollView with your actual ScrollView id
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                } else {
                    Toast.makeText(civilSemester6DetailsActivity.this, "Please select all grades.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean areAllGradesSelected() {
        return spinnerGrade1.getSelectedItemPosition() != 0 &&
                spinnerGrade2.getSelectedItemPosition() != 0 &&
                spinnerGrade3.getSelectedItemPosition() != 0 &&
                spinnerGrade4.getSelectedItemPosition() != 0 &&
                spinnerGrade5.getSelectedItemPosition() != 0 &&
                spinnerGrade6.getSelectedItemPosition() != 0 &&
                spinnerGrade6.getSelectedItemPosition() != 0 &&
                spinnerGrade7.getSelectedItemPosition() != 0 &&
                spinnerGrade8.getSelectedItemPosition() != 0;
    }

    private void calculateSGPA() {
        int[] credits = {4, 4, 4, 3, 3, 1, 2, 2};
        float totalCredits = 0f;
        float totalGradePoints = 0f;

        totalGradePoints += getGradePoint(spinnerGrade1.getSelectedItem().toString()) * credits[0];
        totalGradePoints += getGradePoint(spinnerGrade2.getSelectedItem().toString()) * credits[1];
        totalGradePoints += getGradePoint(spinnerGrade3.getSelectedItem().toString()) * credits[2];
        totalGradePoints += getGradePoint(spinnerGrade4.getSelectedItem().toString()) * credits[3];
        totalGradePoints += getGradePoint(spinnerGrade5.getSelectedItem().toString()) * credits[4];
        totalGradePoints += getGradePoint(spinnerGrade6.getSelectedItem().toString()) * credits[5];
        totalGradePoints += getGradePoint(spinnerGrade7.getSelectedItem().toString()) * credits[6];
        totalGradePoints += getGradePoint(spinnerGrade8.getSelectedItem().toString()) * credits[6];
        for (int credit : credits) {
            totalCredits += credit;
        }

        float sgpa = totalGradePoints / totalCredits;
        tvSGPAResult.setText(String.format("%.2f", sgpa));
    }

    private void clearGrades() {
        spinnerGrade1.setSelection(0);
        spinnerGrade2.setSelection(0);
        spinnerGrade3.setSelection(0);
        spinnerGrade4.setSelection(0);
        spinnerGrade5.setSelection(0);
        spinnerGrade6.setSelection(0);
        spinnerGrade7.setSelection(0);
        spinnerGrade8.setSelection(0);
        tvSGPAResult.setText("SGPA: 0.00");
    }

    private float getGradePoint(String grade) {
        switch (grade) {
            case "S":
                return 10f;
            case "A+":
                return 9f;
            case "A":
                return 8.5f;
            case "B+":
                return 8f;
            case "B":
                return 7.5f;
            case "C+":
                return 7f;
            case "C":
                return 6.5f;
            case "D":
                return 6f;
            case "P":
                return 5.5f;
            case "F":
                return 0f;
            default:
                return 0f;
        }
    }
}