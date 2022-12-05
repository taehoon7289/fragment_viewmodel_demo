package com.minikode.fragment_viewmodel_demo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private var _count: MutableLiveData<Long> = MutableLiveData(0)
    val count: LiveData<Long>
        get() = _count

    private var _label: MutableLiveData<String> = MutableLiveData("")
    val label: LiveData<String>
        get() = _label

    private var _size: MutableLiveData<Int> = MutableLiveData(0)
    val size: LiveData<Int>
        get() = _size

    fun plus() = run { _count.value = _count.value?.plus(1) }
    fun minus() = run { _count.value = _count.value?.minus(1) }
    fun setLabel(label: String) {
        _label.value = label
    }

    fun setSize(size: Int) = run { _size.value = size }
}