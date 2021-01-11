package com.haag.accenturetest.ui.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.haag.accenturetest.R
import com.haag.accenturetest.model.Categories
import kotlinx.android.synthetic.main.categories_list_item.view.*

class CategoriesAdapter(
    private val list: List<Categories>,
    private val listener: (Categories) -> Unit
) : RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.categories_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category: Categories = list[position]
        holder.bind(category)
        holder.itemView.setOnClickListener {
            listener(category)
        }
    }
}

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var category = view.categoryTxt

    fun bind(c: Categories) {
        category.text = c.categories
    }
}
