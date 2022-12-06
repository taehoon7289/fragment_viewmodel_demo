package com.minikode.fragment_viewmodel_demo.ui.main.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.minikode.fragment_viewmodel_demo.databinding.ViewHolderViewPageBinding
import com.minikode.fragment_viewmodel_demo.model.ViewPagerModel

class ViewPagerAdapter : ListAdapter<ViewPagerModel, ViewPagerViewHolder>(object :
    DiffUtil.ItemCallback<ViewPagerModel>() {
    override fun areItemsTheSame(oldItem: ViewPagerModel, newItem: ViewPagerModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ViewPagerModel, newItem: ViewPagerModel): Boolean {
        return oldItem == newItem
    }

}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = ViewHolderViewPageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewPagerViewHolder(
            binding = binding,
        )
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.executePendingBindings()
    }
}