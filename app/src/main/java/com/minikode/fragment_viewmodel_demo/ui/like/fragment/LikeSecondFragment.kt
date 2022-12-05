package com.minikode.fragment_viewmodel_demo.ui.like.fragment

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.minikode.fragment_viewmodel_demo.BaseFragment
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.FragmentLikeSecondBinding
import com.minikode.fragment_viewmodel_demo.ui.like.LikeActivity
import com.minikode.fragment_viewmodel_demo.ui.like.LikeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeSecondFragment : BaseFragment<FragmentLikeSecondBinding>() {
    override val layoutRes: Int = R.layout.fragment_like_second

    private val likeViewModel: LikeViewModel by activityViewModels()

    override fun initView() {
        likeViewModel.setLabel("like activity 두번째 페이지")

        (activity as LikeActivity).checkSize()

        with(binding) {

            with(includeComponent) {

                model = likeViewModel
                buttonPlusCount.setOnClickListener {
                    likeViewModel.plus()
                }

                buttonMinusCount.setOnClickListener {
                    likeViewModel.minus()
                }
            }


            buttonPrevPage.setOnClickListener {
                findNavController().navigate(R.id.second_to_first)
            }

        }
    }


}