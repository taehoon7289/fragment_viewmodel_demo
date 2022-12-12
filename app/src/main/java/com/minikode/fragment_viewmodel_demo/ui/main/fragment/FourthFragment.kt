package com.minikode.fragment_viewmodel_demo.ui.main.fragment

import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.minikode.fragment_viewmodel_demo.BaseFragment
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.FragmentFourthBinding
import com.minikode.fragment_viewmodel_demo.ui.main.MainViewModel
import com.minikode.fragment_viewmodel_demo.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FourthFragment @Inject constructor() : BaseFragment<FragmentFourthBinding>() {

    override val layoutRes: Int = R.layout.fragment_fourth

    private val mainViewModel: MainViewModel by activityViewModels()

    private val temp = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {}

    override fun initView() {

        binding.model = mainViewModel

        (activity as MainActivity).checkSize()

        mainViewModel.setLabel("네번째 페이지")

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
                findNavController().navigate(R.id.fourth_to_third)
//                activity?.supportFragmentManager?.beginTransaction()
//                    ?.replace(R.id.container, mainViewModel.thirdFragment.value!!)
//                    ?.commitNow()
            }
        }

    }
}