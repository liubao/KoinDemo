package com.liubao.koindemo

interface Vehicle {
    fun run()
}

class Car(private val engine: Engine) : Vehicle {
    override fun run() {
        engine.start()
    }

}