package com.liubao.koindemo

interface Engine {
    fun start()
}

class CarEngine : Engine {
    override fun start() {
        println("com.liubao.koindemo.Car engine running")
    }
}