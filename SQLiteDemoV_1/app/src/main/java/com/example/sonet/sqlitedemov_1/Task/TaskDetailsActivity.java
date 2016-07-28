package com.example.sonet.sqlitedemov_1.Task;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sonet.sqlitedemov_1.CollectionList.ConvertDatabaseToList;
import com.example.sonet.sqlitedemov_1.CollectionList.TaskList;
import com.example.sonet.sqlitedemov_1.R;

import java.util.ArrayList;

public class TaskDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    String taskName;
    String taskTag;
    String taskDescription;

    EditText nameEditText;
    EditText tagEditText;
    EditText descriptionEditText;
    ImageButton saveUpdateBtn;

    Context context;

    public TaskDetailsActivity(Context context) {
        this.context = context;
    }

    public TaskDetailsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        nameEditText = (EditText) findViewById(R.id.taskNameEditText);
        tagEditText = (EditText) findViewById(R.id.taskTagEditText);
        descriptionEditText = (EditText) findViewById(R.id.taskDescriptionEditText);
        saveUpdateBtn = (ImageButton) findViewById(R.id.saveUpdateBtn);

        taskName = getIntent().getStringExtra("name");
        taskTag = getIntent().getStringExtra("tag");
        taskDescription = getIntent().getStringExtra("description");

        nameEditText.setText(taskName);
        tagEditText.setText(taskTag);
        descriptionEditText.setText(taskDescription);

        saveUpdateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
