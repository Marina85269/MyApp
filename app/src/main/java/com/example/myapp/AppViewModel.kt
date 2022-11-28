package com.example.myapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {

    val result = MutableLiveData<Int>()

    private val model: Model = Model()


    fun sum(a:Int, b:Int){
       result.value = model.sum(a,b)
    }


}