package com.example.favlistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

   // String [] Categories = {"Hobbies","Sports","Games","Electronics","Food","Countires"};

    interface CategoryisClickedInterface {
       void CategoryisClicked(Category category);

    }

    private ArrayList<Category> categories;
    private CategoryisClickedInterface categoryisClickedListener;

    public CategoryRecyclerAdapter(ArrayList<Category> categories, CategoryisClickedInterface categoryisClickedListener) {
        this.categories = categories;
        this.categoryisClickedListener = categoryisClickedListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category_viewholder, parent, false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {

        holder.getTxtCategoryNumber().setText(Integer.toString(position+1));
        holder.getTxtCategoryName().setText(categories.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryisClickedListener.CategoryisClicked(categories.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public  void addCategory(Category category)  {

        categories.add(category);

        notifyItemInserted(categories.size() - 1);


    }
}
