package com.example.assessment2.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.assessment2.models.MainModel
import com.example.assessment2.reporsitory.MainModelRepository

class MainActivityViewModel : ViewModel() {
    private var mainModelMutableLiveData: MutableLiveData<MainModel?>? = null
    private var mainModelRepository: MainModelRepository? = null
    val mainModelLiveData: LiveData<MainModel?>?
        get() = mainModelMutableLiveData

    fun init() {
        if (mainModelMutableLiveData != null) {
            return
        }
        mainModelRepository = MainModelRepository.instance
        mainModelMutableLiveData = mainModelRepository!!.mainModelData
    }
}