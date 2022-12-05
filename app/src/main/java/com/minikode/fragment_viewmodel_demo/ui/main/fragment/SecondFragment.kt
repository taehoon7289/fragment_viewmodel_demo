package com.minikode.fragment_viewmodel_demo.ui.main.fragment

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.minikode.fragment_viewmodel_demo.BaseFragment
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.FragmentSecondBinding
import com.minikode.fragment_viewmodel_demo.ui.main.MainViewModel
import com.minikode.fragment_viewmodel_demo.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment @Inject constructor() : BaseFragment<FragmentSecondBinding>() {

    override val layoutRes: Int = R.layout.fragment_second

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun initView() {

        binding.model = mainViewModel

        (activity as MainActivity).checkSize()

        mainViewModel.setLabel("두번째 페이지")

        with(binding) {

            with(includeComponent) {

                model = mainViewModel
                buttonPlusCount.setOnClickListener {
                    mainViewModel.plus()
                }

                buttonMinusCount.setOnClickListener {
                    mainViewModel.minus()
                }
            }

            buttonPrevPage.setOnClickListener {
                findNavController().navigate(R.id.second_to_main)
            }

            buttonNextPage.setOnClickListener {
                findNavController().navigate(R.id.second_to_third)
            }
        }

    }
}