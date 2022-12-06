package com.minikode.fragment_viewmodel_demo.ui.like.fragment

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.minikode.fragment_viewmodel_demo.BaseFragment
import com.minikode.fragment_viewmodel_demo.R
import com.minikode.fragment_viewmodel_demo.databinding.FragmentLikeFirstBinding
import com.minikode.fragment_viewmodel_demo.ui.detail.DetailActivity
import com.minikode.fragment_viewmodel_demo.ui.like.LikeActivity
import com.minikode.fragment_viewmodel_demo.ui.like.LikeViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LikeFirstFragment : BaseFragment<FragmentLikeFirstBinding>() {
    override val layoutRes: Int = R.layout.fragment_like_first

    private val likeViewModel: LikeViewModel by activityViewModels()

    private lateinit var startDetailActivity: ActivityResultLauncher<Intent>

    override fun initView() {
        likeViewModel.setLabel("like activity 첫번째 페이지")

        (activity as LikeActivity).checkSize()

        startDetailActivity = createActivityResultLauncher {
            Timber.d("startDetailActivity it : $it")
        }

        with(binding) {

            buttonDetailActivity.setOnClickListener {
                startDetailActivity.launch(Intent(this@LikeFirstFragment.activity,
                    DetailActivity::class.java))
            }

            with(includeComponent) {

                model = likeViewModel
                buttonPlusCount.setOnClickListener {
                    likeViewModel.plus()
                }

                buttonMinusCount.setOnClickListener {
                    likeViewModel.minus()
                }
            }


            buttonNextPage.setOnClickListener {
                findNavController().navigate(R.id.first_to_second)
            }

        }
    }


}