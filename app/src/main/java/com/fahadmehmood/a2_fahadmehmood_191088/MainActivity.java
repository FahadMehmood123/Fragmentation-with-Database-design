package com.fahadmehmood.a2_fahadmehmood_191088;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btninsert;
    Button btnview;
    EditText edtid,edtname,edtcity,edtage;
    List<Student> students=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtid=findViewById(R.id.edt_id);
        edtname=findViewById(R.id.edt_name);
        edtcity=findViewById(R.id.edt_city);
        edtage=findViewById(R.id.edt_age);
        btninsert=findViewById(R.id.btnsave);
        btnview=findViewById(R.id.btnview);
        getSupportActionBar().hide();
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new insertdata()).commit();
            }
        });
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new view()).commit();
            }
        });


    }

}