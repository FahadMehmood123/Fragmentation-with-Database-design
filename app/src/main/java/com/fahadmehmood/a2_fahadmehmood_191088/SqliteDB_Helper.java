package com.fahadmehmood.a2_fahadmehmood_191088;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SqliteDB_Helper extends SQLiteOpenHelper {
    private Context maincontext;
    static private String DATABASE_NAME="studentDetail1.db";
    static private String TABLE_NAME="studentinformation3";
    static private int db_version=1;
    private String Query="create table " + TABLE_NAME + "(Student_ID TEXT primary key,Student_Name TEXT,Student_City TEXT,Student_Age TEXT)";
    public SqliteDB_Helper(Context context) {
        super(context, TABLE_NAME, null, db_version);
        maincontext=context;
        Toast.makeText(context,"Database created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Query);
        Toast.makeText(maincontext,"Table created",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists TABLE_NAME");

    }

    public boolean insertdata1(String std_id,String std_name,String std_city,String std_age){
        SQLiteDatabase sql_db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Student_ID",std_id);
        contentValues.put("Student_Name",std_name);
        contentValues.put("Student_City",std_city);
        contentValues.put("Student_Age",std_age);
        long check=sql_db.insert(TABLE_NAME,null,contentValues);
        if(check==-1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getdata(){
        SQLiteDatabase sql_db=this.getWritableDatabase();
        Cursor cursor=sql_db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }

}
