package com.example.sonet.sqlitedemov_1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.sonet.sqlitedemov_1.CollectionList.ConvertDatabaseToList;
import com.example.sonet.sqlitedemov_1.CollectionList.TaskList;
import com.example.sonet.sqlitedemov_1.CollectionList.TaskListCustomAdapter;
import com.example.sonet.sqlitedemov_1.DataBase.DataBaseAdapter;
import com.example.sonet.sqlitedemov_1.Task.NewTask;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<TaskList> listsOfTask;
    TaskListCustomAdapter adapter;

    Button clickBtn;
    ImageView update;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickBtn = (Button) findViewById(R.id.newTaskBtn);
        listView = (ListView) findViewById(R.id.taskList);

        ConvertDatabaseToList taskList= new ConvertDatabaseToList(this);
        listsOfTask = taskList.getListArray();
        adapter = new TaskListCustomAdapter(this,listsOfTask);
        listView.setAdapter(adapter);

        clickBtn.setOnClickListener(this);
    }


    public void onClick(View v) {

        if (v == clickBtn)
        {
            startActivity(new Intent(MainActivity.this, NewTask.class));
        }
    }

}
