package com.minikode.fragment_viewmodel_demo.ui.main

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
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

    private val startActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        Timber.d("startActivity result : $result")
    }


    override fun initView() {

        with(binding) {
            buttonStartLikeActivity.setOnClickListener {
                startLikeActivity()
            }
        }
    }

    fun checkSize() {
        val size =
            supportFragmentManager.findFragmentById(R.id.container)?.childFragmentManager?.backStackEntryCount
        Timber.d("size : $size")
        mainViewModel.setSize(size!!)
    }

    private fun startLikeActivity() {
        startActivity.launch(Intent(this, LikeActivity::class.java))
    }
}