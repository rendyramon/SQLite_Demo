package com.example.sonet.sqlitedemov_1.CollectionList;

import android.content.Context;
import android.database.Cursor;

import com.example.sonet.sqlitedemov_1.DataBase.DataBaseAdapter;
import com.example.sonet.sqlitedemov_1.MainActivity;

import java.util.ArrayList;

/**
 * Created by Sonet on 7/27/2016.
 */
public class convertDatabaseToList extends MainActivity {

    ArrayList<TaskList> taskLists = new ArrayList<>();
    TaskList taskList;
    DataBaseAdapter dataBaseAdapter;
    Context context;

    public convertDatabaseToList(Context context) {
        this.context = context;
    }

    public  ArrayList<TaskList> getListArray() {
        Cursor cursor = dataBaseAdapter.querySelectAll();

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    taskList = new TaskList();
                    taskList.setTaskName(cursor.getString(0));
                    taskList.setTaskTag(cursor.getString(1));
                    taskList.setTaskDescription(cursor.getString(3));

                    taskLists.add(taskList);

                } while (cursor.moveToNext());
            }
        }
        return taskLists;
    }
}
