package com.example.sonet.sqlitedemov_1.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sonet.sqlitedemov_1.Massage;

import java.util.ArrayList;

/**
 * Created by Sonet on 7/25/2016.
 */
public class DataBaseAdapter  {

    DataBaseHelper helper;

    public DataBaseAdapter(Context context) {
        helper = new DataBaseHelper(context);
    }

    public long queryInsert(String taskName, String taskTag, String taskDescription)
    {
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(helper.TASK_NAME,taskName);
        contentValues.put(helper.TASK_TAG,taskTag);
        contentValues.put(helper.TASK_DESCRIPTION,taskDescription);
        long id = database.insert(helper.TABLE_NAME,null,contentValues);
        return id;
    }

    public Cursor querySelectAll()
    {
        String[] columns = {helper.UID,helper.TASK_NAME,helper.TASK_TAG};
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor =  database.query(helper.TABLE_NAME,columns,null,null,null,null,null);

       /* StringBuffer buffer = new StringBuffer();

        while(cursor.moveToNext())
        {
            int cid = cursor.getInt(0);
            String name = cursor.getString(1);
            String password = cursor.getString(2);
            buffer.append(cid+" "+name+" "+password+"\n");
        }*/

        return cursor;
    }

    static class DataBaseHelper extends SQLiteOpenHelper
    {
        private static String DATABASE_NAME = "student";
        private static int DATABASE_VERSION = 1;
        private static String UID = "_id";
        private static String TABLE_NAME = "TASK";
        private static String TASK_NAME = "task_name";
        private static String TASK_TAG = "task_tag";
        private static String TASK_DESCRIPTION = "task_description";
        String error = "";

        private static String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("
                +UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TASK_NAME +" VARCHAR (200), "+ TASK_TAG +" VARCHAR (200), "+ TASK_DESCRIPTION +" VARCHAR(400));";
        private static String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
        private static Context context;

        public DataBaseHelper(Context context) {
            super(context, DATABASE_NAME,null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                Massage.getMassage(this.context," db File Created Successfully ");
                db.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
                Massage.getMassage(this.context," "+e);
                error = e.toString();
                e.printStackTrace();
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            Massage.getMassage(this.context," onUpgrade called ");


            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException e) {
                Massage.getMassage(this.context," "+e);
                error = e.toString();
            }

        }
    }
}
