package com.aetherwave.gpa_c;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class universalsgpa extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SubjectAdapter subjectAdapter;
    private List<Subject> subjectList;
    private static final int MAX_SUBJECTS = 15;
    private ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universalsgpa);

        recyclerView = findViewById(R.id.recycler_view);
        subjectList = new ArrayList<>();

        // Initialize with three default subjects
        subjectList.add(new Subject("Subject/Course 1", 0, "Grade"));

        subjectAdapter = new SubjectAdapter(subjectList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(subjectAdapter);

        Button addButton = findViewById(R.id.button_add);
        Button removeButton = findViewById(R.id.button_remove);
        Button calculateButton = findViewById(R.id.button_calculate);
        btnback = findViewById(R.id.btn_back);
        View.OnClickListener listenerback = new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                // Simulate the back button press
                getOnBackPressedDispatcher().onBackPressed();
            }
        };
        btnback.setOnClickListener(listenerback);
        addButton.setOnClickListener(view -> {
            if (subjectList.size() < MAX_SUBJECTS) {
                subjectList.add(new Subject("Subject/Course", 0, "Grade"));
                subjectAdapter.notifyItemInserted(subjectList.size() - 1);
            }
        });

        removeButton.setOnClickListener(view -> {
            // Prevent removal of the initial three subjects
            if (subjectList.size() > 1) {
                subjectList.remove(subjectList.size() - 1);
                subjectAdapter.notifyItemRemoved(subjectList.size());
            }
        });

        calculateButton.setOnClickListener(view -> calculateSGPA());
    }

    private void calculateSGPA() {
        double totalCredits = 0;
        double weightedSum = 0;
        boolean validInput = true;

        for (int i = 0; i < subjectList.size(); i++) {
            RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(i);
            if (viewHolder != null) {
                EditText creditText = viewHolder.itemView.findViewById(R.id.subject_credit);
                Spinner gradeSpinner = viewHolder.itemView.findViewById(R.id.subject_grade);

                String creditStr = creditText.getText().toString();
                String grade = gradeSpinner.getSelectedItem().toString();

                if (creditStr.isEmpty() || grade.equals("Grade")) {
                    validInput = false;
                    break;
                }

                int credit = Integer.parseInt(creditStr);
                double gradeValue = getGradeValue(grade);

                totalCredits += credit;
                weightedSum += gradeValue * credit;
            }
        }

        if (validInput) {
            double sgpa = totalCredits > 0 ? weightedSum / totalCredits : 0;
            TextView sgpaResult = findViewById(R.id.sgpa_result);
            sgpaResult.setText(String.format("SGPA: %.2f", sgpa));
        } else {
            Toast.makeText(this, "You must enter both credit and grade for all subjects.", Toast.LENGTH_LONG).show();
        }

    }



    private double getGradeValue(String grade) {
        switch (grade) {
            case "S":
                return 10;
            case "A+":
                return 9;
            case "A":
                return 8.5;
            case "B+":
                return 8;
            case "B":
                return 7.5;
            case "C+":
                return 7;
            case "C":
                return 6.5;
            case "D":
                return 6;
            case "P":
                return 5.5;
            case "F":
                return 0;
            default:
                return 0;
        }
    }
}
