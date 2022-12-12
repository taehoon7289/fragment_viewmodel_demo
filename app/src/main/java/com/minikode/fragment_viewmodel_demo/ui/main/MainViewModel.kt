package com.minikode.fragment_viewmodel_demo.ui.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minikode.fragment_viewmodel_demo.ui.main.fragment.FourthFragment
import com.minikode.fragment_viewmodel_demo.ui.main.fragment.MainFragment
import com.minikode.fragment_viewmodel_demo.ui.main.fragment.SecondFragment
import com.minikode.fragment_viewmodel_demo.ui.main.fragment.ThirdFragment
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

    private var _tabIndex: MutableLiveData<Int> = MutableLiveData(0)
    val tabIndex: LiveData<Int>
        get() = _tabIndex

    fun plus() = run { _count.value = _count.value?.plus(1) }
    fun minus() = run { _count.value = _count.value?.minus(1) }
    fun setLabel(label: String) {
        _label.value = label
    }

    fun setSize(size: Int) = run { _size.value = size }
    fun setTabIndex(tabIndex: Int) = run { _tabIndex.value = tabIndex }

    private var _mainFragment: MutableLiveData<Fragment> = MutableLiveData(MainFragment())
    val mainFragment: LiveData<Fragment>
        get() = _mainFragment

    private var _secondFragment: MutableLiveData<Fragment> = MutableLiveData(SecondFragment())
    val secondFragment: LiveData<Fragment>
        get() = _secondFragment

    private var _thirdFragment: MutableLiveData<Fragment> = MutableLiveData(ThirdFragment())
    val thirdFragment: LiveData<Fragment>
        get() = _thirdFragment

    private var _fourthFragment: MutableLiveData<Fragment> = MutableLiveData(FourthFragment())
    val fourthFragment: LiveData<Fragment>
        get() = _fourthFragment

}