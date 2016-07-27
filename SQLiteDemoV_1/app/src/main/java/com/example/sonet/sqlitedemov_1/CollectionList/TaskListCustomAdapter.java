package com.example.sonet.sqlitedemov_1.CollectionList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sonet.sqlitedemov_1.R;
import com.example.sonet.sqlitedemov_1.Task.TaskDetailsActivity;

import java.util.ArrayList;

/**
 * Created by Sonet on 7/27/2016.
 */
public class TaskListCustomAdapter extends ArrayAdapter<TaskList> {

    ArrayList<TaskList> TaskLists;
    Context context;
    private static int POSITION = 0;

    public TaskListCustomAdapter(Context context, ArrayList<TaskList> TaskLists) {
        super(context, R.layout.activity_main_liststyle, TaskLists);
        this.TaskLists = TaskLists;
        this.context = context;
    }

    public class ViewHolder {
        TextView taskName;
        ImageButton deleteBtn;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        this.POSITION = position;
        ViewHolder holder = new ViewHolder();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_main_liststyle, null, true);

            holder.taskName = (TextView) convertView.findViewById(R.id.taskName_firstScreenListStyle);
            holder.deleteBtn = (ImageButton) convertView.findViewById(R.id.deleteBtn);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.taskName.setText(TaskLists.get(position).getTaskName());

        holder.taskName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, TaskDetailsActivity.class);
                intent.putExtra("Position", String.valueOf(POSITION));

                context.startActivity(intent);

            }
        });

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }
}
