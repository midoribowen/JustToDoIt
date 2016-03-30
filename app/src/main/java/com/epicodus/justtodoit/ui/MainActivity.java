package com.epicodus.justtodoit.ui;

import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.epicodus.justtodoit.JustToDoItApplication;
import com.epicodus.justtodoit.R;
import com.epicodus.justtodoit.adapters.FirebaseCategoryListAdapter;
import com.epicodus.justtodoit.models.Category;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.firebase.client.core.Path;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Query mQuery;
    private Firebase mFirebaseRef;
    private String mCategories;
    private FirebaseCategoryListAdapter mAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Bind(R.id.addCategoryButton) FloatingActionButton mAddCategoryButton;
    @Bind(R.id.addTaskButton) FloatingActionButton mAddTaskButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Firebase.setAndroidContext(this);
        mFirebaseRef = JustToDoItApplication.getAppInstance().getFirebaseRef();
        mCategories = mFirebaseRef.getKey();

        setUpFirebaseQuery();
        setUpRecyclerView();

        mAddCategoryButton.setOnClickListener(this);
        mAddTaskButton.setOnClickListener(this);
    }

    private void setUpFirebaseQuery() {
        String location = mFirebaseRef.child("categories").toString();
        mQuery = new Firebase(location);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseCategoryListAdapter(mQuery, Category.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
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
