package com.epicodus.justtodoit.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epicodus.justtodoit.JustToDoItApplication;
import com.epicodus.justtodoit.R;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddCategoryFragment extends DialogFragment implements View.OnClickListener {
    private Firebase mFirebaseRef;
    @Bind(R.id.addCategoryEditText) EditText mAddCategoryEditText;
    @Bind(R.id.addNewCategoryButton) Button mAddCategoryButton;

//    Binders here

    public AddCategoryFragment() {

    }

    public static AddCategoryFragment newInstance() {
        return new AddCategoryFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_category, container, false);
        ButterKnife.bind(this, view);
        mAddCategoryButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.addNewCategoryButton:
                String categoryName = mAddCategoryEditText.getText().toString();
                saveCategoryToFirebase(categoryName);
                dismiss();
                Toast.makeText(getContext(), "Saved!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void saveCategoryToFirebase(String categoryName) {
        JustToDoItApplication.getAppInstance()
                .getFirebaseRef()
                .child("categories/")
                .push()
                .child("name/")
                .setValue(categoryName);
    }

}
