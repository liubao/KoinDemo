package com.liubao.koindemo

import Car
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarViewModel : ViewModel() {

    val carLiveData = MutableLiveData<Car>()

}