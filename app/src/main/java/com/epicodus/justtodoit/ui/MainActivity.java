package com.epicodus.justtodoit.ui;

import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.epicodus.justtodoit.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.addCategoryButton) FloatingActionButton mAddCategoryButton;
    @Bind(R.id.addTaskButton) FloatingActionButton mAddTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAddCategoryButton.setOnClickListener(this);
        mAddTaskButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addCategoryButton:
                launchAddCategoryFragment();
                break;
//            case R.id.addTaskButton:
//                launchAddTaskFragment();
//                break;
        }
    }

    private void launchAddCategoryFragment() {
        FragmentManager fm = getSupportFragmentManager();
        AddCategoryFragment addCategory = AddCategoryFragment.newInstance();
        addCategory.show(fm, "fragment_add_category");
    }

//    private void launchAddTaskFragment() {
//        FragmentManager fm = getSupportFragmentManager();
//        AddTaskFragment addTask = addTaskFragment.newInstance();
//        addTask.show(fm, "fragment_add_task");
//    }
}
