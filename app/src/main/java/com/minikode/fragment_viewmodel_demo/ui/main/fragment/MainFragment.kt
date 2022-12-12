package com.minikode.fragment_viewmodel_demo.ui.main.fragment

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.minikode.fragment_viewmodel_demo.BaseFragment
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.FragmentMainBinding
import com.minikode.fragment_viewmodel_demo.ui.main.MainActivity
import com.minikode.fragment_viewmodel_demo.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment @Inject constructor() : BaseFragment<FragmentMainBinding>() {

    override val layoutRes: Int = R.layout.fragment_main

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun initView() {

        mainViewModel.setLabel("메인 페이지")

        (activity as MainActivity).checkSize()

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

            val temp = activity?.supportFragmentManager?.fragments


//            buttonNextPage.setOnClickListener(
//                Navigation.createNavigateOnClickListener(R.id.main_to_second)
//            )


            buttonNextPage.setOnClickListener {
                findNavController().navigate(R.id.main_to_second)
//                activity?.supportFragmentManager?.beginTransaction()
//                    ?.replace(R.id.container, mainViewModel.secondFragment.value!!)
//                    ?.commitNow()

            }


//            buttonNextPage.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.main_to_like))

        }

    }
}