package com.liubao.koindemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.context.GlobalContext
import org.koin.core.parameter.parametersOf

class CarViewModel : ViewModel() {
    val car: Car = GlobalContext.get().get(parameters = { parametersOf(CarEngine()) })

    val carLiveData = MutableLiveData<Car>()

}