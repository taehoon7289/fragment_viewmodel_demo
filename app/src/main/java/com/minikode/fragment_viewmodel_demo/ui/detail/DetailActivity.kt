package com.minikode.fragment_viewmodel_demo.ui.detail

import androidx.annotation.Dimension
import com.minikode.fragment_viewmodel_demo.BaseActivity
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override val layoutRes: Int = R.layout.activity_detail

    override fun initView() {
        binding.textViewTitle.setTextSize(Dimension.SP, 30f)
    }
}