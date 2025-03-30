package com.aetherwave.gpa_c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    private final List<Subject> subjectList;

    public SubjectAdapter(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_subject, parent, false);
        return new SubjectViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject = subjectList.get(position);
        holder.subjectNumber.setText(String.valueOf(position + 1)); // Set the subject number
        holder.subjectName.setHint("Subject/Course");

        // Set hint for credit
        holder.subjectCredit.setHint("Credit");

        // Set up spinner with grade options and hint
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(holder.itemView.getContext(),
                R.array.grades_arrayu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.subjectGrade.setAdapter(adapter);

        // Set the spinner to show "Grade" as hint
        if (subject.getGrade() == null || subject.getGrade().isEmpty()) {
            holder.subjectGrade.setSelection(adapter.getCount()); // This assumes "Grade" is the last item in the array
        } else {
            int spinnerPosition = adapter.getPosition(subject.getGrade());
            holder.subjectGrade.setSelection(spinnerPosition);
        }
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    static class SubjectViewHolder extends RecyclerView.ViewHolder {
        TextView subjectNumber;
        EditText subjectName;
        EditText subjectCredit;
        Spinner subjectGrade;

        SubjectViewHolder(View itemView) {
            super(itemView);
            subjectNumber = itemView.findViewById(R.id.subject_number);
            subjectName = itemView.findViewById(R.id.subject_name);
            subjectCredit = itemView.findViewById(R.id.subject_credit);
            subjectGrade = itemView.findViewById(R.id.subject_grade);
        }
    }
}

