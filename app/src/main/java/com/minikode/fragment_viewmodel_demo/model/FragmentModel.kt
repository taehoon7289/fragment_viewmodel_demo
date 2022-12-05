package com.minikode.fragment_viewmodel_demo.model

data class FragmentModel(
    var count: Long = 0,
    var label: String = "",
) {
    fun plus() = ++count
    fun minus() = --count
}
