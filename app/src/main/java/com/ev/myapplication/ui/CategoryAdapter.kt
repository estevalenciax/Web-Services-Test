package com.ev.myapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ev.myapplication.databinding.ItemListBinding

class CategoryAdapter(private val itemList: List<String>, private val callback: OnItemClick) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    inner class CategoryViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: String) {
            binding.category.text = category
            binding.category.setOnClickListener {
                callback.onItemClick(category)
            }
        }
    }

    interface OnItemClick {
        fun onItemClick(category: String)
    }
}