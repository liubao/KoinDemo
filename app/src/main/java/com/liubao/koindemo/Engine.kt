interface Engine {
    fun start()
}

class CarEngine : Engine {
    override fun start() {
        println("Car engine running")
    }
}