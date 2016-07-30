package com.example.sonet.sqlitedemov_1.Task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sonet.sqlitedemov_1.DataBase.DataBaseAdapter;
import com.example.sonet.sqlitedemov_1.Massage;
import com.example.sonet.sqlitedemov_1.R;

public class NewTaskActivity extends AppCompatActivity implements View.OnClickListener {

    DataBaseAdapter databaseHelper;

    EditText taskName;
    EditText taskTag;
    EditText taskDescription;
    ImageButton submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        taskName = (EditText) findViewById(R.id.taskNameEditText);
        taskTag = (EditText) findViewById(R.id.taskTagEditText);
        taskDescription = (EditText) findViewById(R.id.taskDescriptionEditText);
        submitBtn = (ImageButton) findViewById(R.id.saveUpdateBtn);

        databaseHelper = new DataBaseAdapter(this);

        submitBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String name = taskName.getText().toString();
        String tag = taskTag.getText().toString();
        String description = taskDescription.getText().toString();

        long id = databaseHelper.queryInsert(name, tag, description);

        if (id < 0)
            Massage.getMassage(this, "Failed !!!");
        else
            Massage.getMassage(this, "Inserted data");

    }
}
