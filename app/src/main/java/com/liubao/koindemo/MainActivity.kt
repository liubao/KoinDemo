package com.liubao.koindemo

import Car
import CarEngine
import Vehicle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {
    // Lazy injected
    // The by inject() function allows us to retrieve Koin instances,
    // in Android components runtime (Activity, fragment, Service...)
    val carByLazy: Vehicle by inject()

    // The get() function is here to retrieve directly an instance (non lazy)
    val carByGet: Vehicle = get()

    // Lazy Inject ViewModel
    val carViewModelByLazy by viewModel<CarViewModel>()
    val carViewModelByGet = get<CarViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(findViewById<TextView>(R.id.textView)) {
            setOnClickListener {
                carByLazy.run()
                with(createCarUsingParameterInjection()) {
                    this.run()
                }
            }
        }
        carViewModelByLazy.carLiveData.observe(this, Observer {

        })
    }

    /**
     * Create an instance using parameter injection.
     */
    fun createCarUsingParameterInjection(): Car {
        return get<Car>(parameters = { parametersOf(CarEngine()) })
    }

    /**
     * Create an instance using name qualifier.
     */
    fun createCarUsingNameQualifier(): Car {
        return get<Car>(qualifier = named(CAR_QUALIFIER))
    }
}