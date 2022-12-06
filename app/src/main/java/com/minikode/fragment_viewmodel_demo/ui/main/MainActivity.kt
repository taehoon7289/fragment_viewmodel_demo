package com.minikode.fragment_viewmodel_demo.ui.main

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import com.minikode.fragment_viewmodel_demo.BaseActivity
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.ActivityMainBinding
import com.minikode.fragment_viewmodel_demo.ui.like.LikeActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutRes: Int = R.layout.activity_main

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var likeActivityLauncher: ActivityResultLauncher<Intent>

    override fun initView() {
        likeActivityLauncher = createActivityResultLauncher { activityResult ->
            Timber.d("activityResult : $activityResult")
        }
        with(binding) {
            buttonStartLikeActivity.setOnClickListener {
                likeActivityLauncher.launch(Intent(this@MainActivity, LikeActivity::class.java))
            }
        }
    }

    fun checkSize() {
        val size =
            supportFragmentManager.findFragmentById(R.id.container)?.childFragmentManager?.backStackEntryCount
        Timber.d("size : $size")
        mainViewModel.setSize(size!!)
    }

}