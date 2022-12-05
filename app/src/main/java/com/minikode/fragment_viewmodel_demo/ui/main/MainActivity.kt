package com.minikode.fragment_viewmodel_demo.ui.main

import androidx.activity.viewModels
import com.minikode.fragment_viewmodel_demo.BaseActivity
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutRes: Int = R.layout.activity_main

    private val fragmentViewModel: FragmentViewModel by viewModels()

    override fun initView() {


    }

    fun checkSize() {
//        val size = supportFragmentManager.backStackEntryCount
        val size =
            supportFragmentManager.findFragmentById(R.id.container)?.childFragmentManager?.backStackEntryCount
        Timber.d("size : $size")
        fragmentViewModel.setSize(size!!)
    }
}