package com.example.mazano.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mazano.databinding.RecyclerItemBinding
import com.example.mazano.models.ItemModel


class CategoryRecyclerAdapter : RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemBinding.bind(itemView)
        fun bind(model: ItemModel) {
            binding.title.text = model.title

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
