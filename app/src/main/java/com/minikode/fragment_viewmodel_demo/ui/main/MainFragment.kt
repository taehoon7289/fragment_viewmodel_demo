package com.minikode.fragment_viewmodel_demo.ui.main

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.minikode.fragment_viewmodel_demo.BaseFragment
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment @Inject constructor() : BaseFragment<FragmentMainBinding>() {

    override val layoutRes: Int = R.layout.fragment_main

    private val fragmentViewModel: FragmentViewModel by activityViewModels()

    override fun initView() {

        fragmentViewModel.setLabel("메인 페이지")

        (activity as MainActivity).checkSize()

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


            buttonNextPage.setOnClickListener {
                findNavController().navigate(R.id.main_to_second)
            }

        }

    }
}