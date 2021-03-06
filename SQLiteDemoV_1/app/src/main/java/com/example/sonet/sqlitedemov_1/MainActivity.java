package com.example.sonet.sqlitedemov_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.sonet.sqlitedemov_1.CollectionList.ConvertDatabaseToList;
import com.example.sonet.sqlitedemov_1.CollectionList.TaskList;
import com.example.sonet.sqlitedemov_1.CollectionList.TaskListCustomAdapter;
import com.example.sonet.sqlitedemov_1.Task.NewTaskActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<TaskList> listsOfTask;
    TaskListCustomAdapter adapter;

    ImageButton clickBtn;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickBtn = (ImageButton) findViewById(R.id.createNewBtn);
        listView = (ListView) findViewById(R.id.taskList);

        ConvertDatabaseToList taskList = new ConvertDatabaseToList(this);
        listsOfTask = taskList.getListArray();
        adapter = new TaskListCustomAdapter(this, listsOfTask);
        listView.setAdapter(adapter);

        clickBtn.setOnClickListener(this);
    }


    public void onClick(View v) {

        if (v == clickBtn) {
            startActivity(new Intent(MainActivity.this, NewTaskActivity.class));
        }
    }
}
