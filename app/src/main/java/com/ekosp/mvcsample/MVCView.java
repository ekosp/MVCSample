package com.ekosp.mvcsample;

/**
 * Created by Eko Setyo Purnomo on 08-Mar-18.
 * Find me on https://ekosp.com
 * Or email me directly to ekosetyopurnomo@gmail.com
 */

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MVCView extends Activity {
    public static final String APP_TAG = "com.ekosp...MVCView";

    private ListView lvTask;
    private Button btNewTask;
    private EditText etNewTask;

    private MVCController controller;

    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.ui_main);
        this.controller = new MVCController(this);
        this.lvTask = (ListView) this.findViewById(R.id.lvTask);
        this.btNewTask = (Button) this.findViewById(R.id.btNewTask);
        this.etNewTask = (EditText)
                this.findViewById(R.id.etNewTask);

        this.btNewTask.setOnClickListener(this.handleNewTaskEvent);
        this.populateTasks();
    }

    private void populateTasks() {
        final List<String> tasks = this.controller.getTasks();
        Log.d(MVCView.APP_TAG, String.format("%d found tasks ",
                tasks.size()));

        this.lvTask.setAdapter(new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,
                        tasks.toArray(new String[]{})));

        this.lvTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent,
                                    final View view, final int position, final long id) {
                Log.d(MVCView.APP_TAG, String.format("task id: %d and position: %d", id, position));

                final TextView v = (TextView) view;
                MVCView.this.controller.deleteTask
                        (v.getText().toString());
                MVCView.this.populateTasks();
            }
        });
    }

    private final View.OnClickListener handleNewTaskEvent =
            new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    Log.d(APP_TAG, "New Task button added");
                    MVCView.this.controller.addTask(MVCView.this
                            .etNewTask.getText().toString());
                    MVCView.this.populateTasks();
                }
            };

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}