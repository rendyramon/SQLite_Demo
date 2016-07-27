package com.example.sonet.sqlitedemov_1.CollectionList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sonet.sqlitedemov_1.R;

import java.util.ArrayList;

/**
 * Created by Sonet on 7/27/2016.
 */
public class TaskListCustomAdapter extends ArrayAdapter<TaskList> {

    ArrayList<TaskList> TaskLists;
    Context context;

    public TaskListCustomAdapter(Context context, ArrayList<TaskList> TaskLists) {
        super(context, R.layout.activity_main_liststyle, TaskLists);
        this.TaskLists = TaskLists;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_main_liststyle,null,true);
        }

        TaskList taskList = TaskLists.get(position);
        TextView taskName = (TextView) convertView.findViewById(R.id.taskName_firstScreenListStyle);

        taskName.setText(taskList.getTaskName());

        return convertView;
    }
}
