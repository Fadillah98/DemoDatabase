package com.myapplicationdev.android.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Tasks> {

    private ArrayList<Tasks> task;
    private Context context;
    private TextView tvID, tvDescription, tvDate;

    public TaskAdapter(Context context, int resource, ArrayList<Tasks> objects){
        super(context, resource, objects);
        task = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvID =   rowView.findViewById(R.id.tvID);
        tvDescription =  rowView.findViewById(R.id.tvDescription);
        tvDate = rowView.findViewById(R.id.tvDate);

        Tasks currentTask = task.get(position);

        String id = Integer.toString(currentTask.getId());
        tvID.setText(id);
        tvDescription.setText(currentTask.getDescription());
        tvDate.setText(currentTask.getDate());
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
