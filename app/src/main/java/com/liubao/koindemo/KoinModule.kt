package com.liubao.koindemo

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.factory
import org.koin.dsl.module

const val CAR_QUALIFIER = "car_qualifier"
val vehicleModule = module {
//     Single instance of Engine
    /*single<Engine> {
        CarEngine()
    }*/
    // Simple Engine Factory
    factory<Engine> { CarEngine() }
    factory<Vehicle> {
        Car(get())
    }
    // Defining an injected parameter
    factory<Car>() { (engine: Engine) ->
        Car(engine = engine)
    }
    factory(named(CAR_QUALIFIER)) {
        Car(get())
    }
    viewModel { CarViewModel() }
}