package com.minikode.fragment_viewmodel_demo.ui.main.fragment

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.minikode.fragment_viewmodel_demo.BaseFragment
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.FragmentSecondBinding
import com.minikode.fragment_viewmodel_demo.model.ViewPagerModel
import com.minikode.fragment_viewmodel_demo.ui.main.MainActivity
import com.minikode.fragment_viewmodel_demo.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment @Inject constructor() : BaseFragment<FragmentSecondBinding>() {

    override val layoutRes: Int = R.layout.fragment_second

    private val mainViewModel: MainViewModel by activityViewModels()

    private val tabTitleArray =
        arrayOf("가", "나", "다", "라", "마", "바", "바", "사", "아", "자", "차", "카", "타", "파", "하")

    override fun initView() {

        binding.model = mainViewModel

        (activity as MainActivity).checkSize()

        mainViewModel.setLabel("두번째 페이지")

        with(binding) {

            val viewPagerAdapter = ViewPagerAdapter()
            viewPager.adapter = viewPagerAdapter

            viewPagerAdapter.submitList(tabTitleArray.map {
                ViewPagerModel(
                    tabName = it,
                    label = it,
                )
            })

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = tabTitleArray[position]
            }.attach()

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    Timber.d("onTabSelected : $tab")
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    Timber.d("onTabUnselected : $tab")
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    Timber.d("onTabReselected : $tab")
                }
            })

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