package com.fahadmehmood.a2_fahadmehmood_191088;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class insertdata extends Fragment {
    EditText edtid,edtname,edtcity,edtage;
    SqliteDB_Helper db;
    List<Student> students=new ArrayList<>();
    Button btn;

    public insertdata() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item, container, false);
        btn=container.findViewById(R.id.btnsave);
        edtid=container.findViewById(R.id.edt_id);
        edtname=container.findViewById(R.id.edt_name);
        edtcity=container.findViewById(R.id.edt_city);
        edtage=container.findViewById(R.id.edt_age);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students.add(new Student(edtid.getText().toString(),
                        edtname.getText().toString(),edtcity.getText().toString(),
                        edtage.getText().toString()));
                db=new SqliteDB_Helper(getContext());
                db.insertdata1(edtid.getText().toString(),edtname.getText().toString(),
                        edtcity.getText().toString(),edtage.getText().toString());
            }
        });
        return view;
    }

}