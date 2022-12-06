package com.minikode.fragment_viewmodel_demo.ui.main.fragment

import androidx.recyclerview.widget.RecyclerView
import com.minikode.fragment_viewmodel_demo.databinding.ViewHolderViewPageBinding
import com.minikode.fragment_viewmodel_demo.model.ViewPagerModel

class ViewPagerViewHolder(
    val binding: ViewHolderViewPageBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ViewPagerModel) {
        binding.model = item
    }
}