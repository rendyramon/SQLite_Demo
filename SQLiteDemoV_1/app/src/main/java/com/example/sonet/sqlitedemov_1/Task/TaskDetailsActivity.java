package com.example.sonet.sqlitedemov_1.Task;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sonet.sqlitedemov_1.CollectionList.ConvertDatabaseToList;
import com.example.sonet.sqlitedemov_1.CollectionList.TaskList;
import com.example.sonet.sqlitedemov_1.DataBase.DataBaseAdapter;
import com.example.sonet.sqlitedemov_1.MainActivity;
import com.example.sonet.sqlitedemov_1.Massage;
import com.example.sonet.sqlitedemov_1.R;

import java.util.ArrayList;

public class TaskDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    DataBaseAdapter databaseHelper;
    ArrayList<TaskList> taskLists;

    String taskName;
    String taskTag;
    String taskDescription;
    int taskID;
    int arryListPosition;

    EditText nameEditText;
    EditText tagEditText;
    EditText descriptionEditText;
    ImageButton saveUpdateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        nameEditText = (EditText) findViewById(R.id.taskNameEditText);
        tagEditText = (EditText) findViewById(R.id.taskTagEditText);
        descriptionEditText = (EditText) findViewById(R.id.taskDescriptionEditText);
        saveUpdateBtn = (ImageButton) findViewById(R.id.saveUpdateBtn);

        taskLists = new ConvertDatabaseToList(this).getListArray();
        databaseHelper = new DataBaseAdapter(this);

        taskID = getIntent().getIntExtra("taskID", 0);
        arryListPosition = taskID - 1;

        taskName = taskLists.get(arryListPosition).getTaskName();
        taskTag = taskLists.get(arryListPosition).getTaskTag();
        taskDescription = taskLists.get(arryListPosition).getTaskDescription();

        nameEditText.setText(taskName);
        tagEditText.setText(taskTag);
        descriptionEditText.setText(taskDescription);

        saveUpdateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        taskName = nameEditText.getText().toString();
        taskTag = tagEditText.getText().toString();
        taskDescription = descriptionEditText.getText().toString();

        databaseHelper.queryUpdate(taskName, taskTag, taskDescription, taskID);
        startActivity(new Intent(this, MainActivity.class));
    }
}
