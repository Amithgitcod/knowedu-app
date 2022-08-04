package com.example.knowedu.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.knowedu.model.Info;
import com.example.knowedu.params.params;

import java.util.ArrayList;
import java.util.List;

public class MyDBhandler extends SQLiteOpenHelper {

    public MyDBhandler( Context context) {
        super(context, params.DB_NAME, null, params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + params.TABLE_NAME + "(" + params.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + params.KEY_NAME + " TEXT, " + params.KEY_EMAIL + " TEXT, " + params.KEY_MARKS + " TEXT" + ")";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String drop = "drop Table if exists " + params.TABLE_NAME;
            db.execSQL(drop);
    }



    public long addinfo(Info info){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(params.KEY_NAME,info.getName());
        values.put(params.KEY_EMAIL,info.getEmail());
        values.put(params.KEY_MARKS,info.getMarks());

        long result = db.insert(params.TABLE_NAME,null,values);
        //db.close();
        if(result == -1){
            return -1;
        }
        else return result;

    }

    public List<Info> getinfo(){
        List<Info> infoList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //query to read from database
        String select = "SELECT * FROM " + params.TABLE_NAME + " ORDER BY " + params.KEY_MARKS + " DESC";
        Cursor cursor = db.rawQuery(select,null);

        //loop through now
        if(cursor.moveToFirst()){
            do{
                Info info = new Info();
                info.setId(Integer.parseInt(cursor.getString(0)));
                info.setName(cursor.getString(1));
                info.setEmail(cursor.getString(2));
                info.setMarks(cursor.getString(3));
                infoList.add(info);
            }while (cursor.moveToNext());
        }
        return infoList;
    }

    public long addinfo(String nameTXT, String emailTXT, String marksTXT) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(params.KEY_NAME,nameTXT);
        values.put(params.KEY_EMAIL,emailTXT);
        values.put(params.KEY_MARKS,marksTXT);

        long result = db.insert(params.TABLE_NAME,null,values);
        //db.close();
        if(result == -1){
            return -1;
        }
        else return result;

    }

    public boolean deleteinfo(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        long res = db.delete(params.TABLE_NAME,params.KEY_ID + "=?",new String[]{String.valueOf(id)} );
        db.close();
        if(res == -1){
            return false;
        }
        else return true;
    }


    public List<Info> getidinfo(String id){
        List<Info> infoList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //query to read from database
       // String select = "SELECT * FROM " + params.TABLE_NAME + " WHERE ";
        Cursor cursor = db.rawQuery("SELECT * FROM " + params.TABLE_NAME + " WHERE "
               + params.KEY_ID + "=?", new String[]{id});

        //loop through now

        if(cursor.moveToFirst()){
            do{
                Info info = new Info();
                info.setId(Integer.parseInt(cursor.getString(0)));
                info.setName(cursor.getString(1));
                info.setEmail(cursor.getString(2));
                info.setMarks(cursor.getString(3));
                infoList.add(info);
            }while (cursor.moveToNext());
        }


        return infoList;
    }

}
