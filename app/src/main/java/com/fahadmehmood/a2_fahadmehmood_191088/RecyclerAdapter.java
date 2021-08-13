package com.fahadmehmood.a2_fahadmehmood_191088;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<Student> studentlist;

    public RecyclerAdapter(Context context, List<Student> studentlist) {
        this.context = context;
        this.studentlist = studentlist;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Student student=studentlist.get(position);
        holder.txtid.setText("Student ID: "+ student.getId());
        holder.txtname.setText("Name: "+ student.getName());
        holder.txtcity.setText("City: "+ student.getCity());
        holder.txtage.setText("Age: "+ student.getAge());

    }

    @Override
    public int getItemCount() {
        return studentlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtid,txtname,txtcity,txtage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtid=itemView.findViewById(R.id.id);
            txtname=itemView.findViewById(R.id.name);
            txtcity=itemView.findViewById(R.id.city);
            txtage=itemView.findViewById(R.id.age);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
