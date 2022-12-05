package com.minikode.fragment_viewmodel_demo.ui.like


import androidx.activity.viewModels
import com.minikode.fragment_viewmodel_demo.BaseActivity
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.ActivityLikeBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LikeActivity : BaseActivity<ActivityLikeBinding>() {
    override val layoutRes: Int = R.layout.activity_like

    private val likeViewModel: LikeViewModel by viewModels()

    override fun initView() {

    }

    fun checkSize() {
        val size =
            supportFragmentManager.findFragmentById(R.id.container)?.childFragmentManager?.backStackEntryCount
        Timber.d("size : $size")
        likeViewModel.setSize(size!!)
    }

}