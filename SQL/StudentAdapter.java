package com.android_lab.sqlitedemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private ArrayList<Student> dataset;
    private String[] courses;

    private OnClicklistener mListener;

    public interface OnClicklistener {
        public void onClick(int position);
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle;

        public StudentViewHolder(View v, final OnClicklistener mListener) {
            super(v);
            title = v.findViewById(R.id.title);
            subtitle = v.findViewById(R.id.subtitle);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onClick(getAdapterPosition());
                }
            });
        }
    }

    public StudentAdapter(ArrayList<Student> dataset, OnClicklistener mListener) {
        this.dataset = dataset;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_layout, parent, false);

        StudentViewHolder vh = new StudentViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = dataset.get(position);
        holder.title.setText(student.name);
        holder.subtitle.setText(student.rollNo);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void update(ArrayList<Student> dataset) {
        this.dataset = dataset;
        this.notifyDataSetChanged();
    }

}
