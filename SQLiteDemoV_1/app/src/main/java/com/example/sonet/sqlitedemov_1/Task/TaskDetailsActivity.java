package com.example.sonet.sqlitedemov_1.Task;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sonet.sqlitedemov_1.CollectionList.ConvertDatabaseToList;
import com.example.sonet.sqlitedemov_1.CollectionList.TaskList;
import com.example.sonet.sqlitedemov_1.R;

import java.util.ArrayList;

public class TaskDetailsActivity extends AppCompatActivity {

    ArrayList<TaskList> taskLists = new ArrayList<>();
    int Position;
    String taskName;
    String taskTag;
    String taskDescription;
    Context context;
    TextView taskDetails;

    public TaskDetailsActivity(Context context)
    {
        this.context = context;
    }

    public TaskDetailsActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        Intent intent = getIntent();
        Position = Integer.parseInt(intent.getStringExtra("Position"));

        taskLists = new ConvertDatabaseToList(this).getListArray();
        taskName = taskLists.get(Position).getTaskName();
        taskTag = taskLists.get(Position).getTaskTag();
        taskDescription = taskLists.get(Position).getTaskDescription();

        String totalInfo = taskName +" \n" +taskTag +" \n" +taskDescription;

        taskDetails = (TextView) findViewById(R.id.taskDetailsTextView);

        taskDetails.setText(totalInfo);
    }
}
