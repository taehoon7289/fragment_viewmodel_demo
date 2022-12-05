package com.minikode.fragment_viewmodel_demo.ui.main

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.minikode.fragment_viewmodel_demo.BaseFragment
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.FragmentThirdBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ThirdFragment @Inject constructor() : BaseFragment<FragmentThirdBinding>() {

    override val layoutRes: Int = R.layout.fragment_third

    private val fragmentViewModel: FragmentViewModel by activityViewModels()

    override fun initView() {

        binding.model = fragmentViewModel

        (activity as MainActivity).checkSize()

        fragmentViewModel.setLabel("세번째 페이지")

        with(binding) {

            with(includeComponent) {

                model = fragmentViewModel
                buttonPlusCount.setOnClickListener {
                    fragmentViewModel.plus()
                }

                buttonMinusCount.setOnClickListener {
                    fragmentViewModel.minus()
                }
            }

            buttonPrevPage.setOnClickListener {
                findNavController().navigate(R.id.third_to_second)
            }

            buttonNextPage.setOnClickListener {
                findNavController().navigate(R.id.third_to_fourth)
            }

        }

    }
}