package com.myapplicationdev.android.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTasks;
    TextView tvResults;
    ListView lv;
    ArrayList<Tasks> task;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);
        lv = findViewById(R.id.lvTasks);

        task = new ArrayList<Tasks>();
        aa = new TaskAdapter(this, R.layout.row, task);
        DBHelper db = new DBHelper(MainActivity.this);
        ArrayList<Tasks> data = db.getTasks();
        aa = new TaskAdapter(this,R.layout.row,data);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertTask("Submit RJ", "25 apr 2016");
                db.close();
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<String> data = db.getTaskContent();
                db.close();

                String text = "";
                for (int i = 0; i < data.size(); i++){
                    Log.d("Database Content", i + ". " + data.get(i));
                    text += i + ". " + data.get(i) + "\n";
                }
                tvResults.setText(text);
            }
        });
    }
}
