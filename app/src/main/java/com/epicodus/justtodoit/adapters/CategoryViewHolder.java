package com.epicodus.justtodoit.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.justtodoit.R;
import com.epicodus.justtodoit.models.Category;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @Bind(R.id.categoryNameTextView) TextView mCategoryNameTextView;

    private Context mContext;

    ArrayList<Category> mCategories = new ArrayList<>();

    public CategoryViewHolder(View itemView, ArrayList<Category> categories) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mCategories = categories;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        Intent intent = new Intent(mContext, CategoryDetailActivity.class);
//        intent.putExtra("position", getLayoutPosition() + "");
//        intent.putExtra("categories", Parcels.wrap(mCategories));
//        mContext.startActivity(intent);
    }

    public void bindCategory(Category category) {
        mCategoryNameTextView.setText(category.getName());
    }
}
