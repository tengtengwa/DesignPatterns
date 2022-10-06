package creationPattern.factory

fun main() {
    val benz = CarFactory.makeCar(CarFactory.BENZ)
    benz.doSomething()
    val byd = CarFactory.makeCar(CarFactory.BYD)
    byd.doSomething()
}

/**
 * 简单工厂模式
 */

class CarFactory  {
    companion object {
        const val BENZ = "Benz"
        const val BYD = "BYD"

        @JvmStatic
        fun makeCar(carName: String): ICar {
            return when (carName) {
                BENZ -> BenzCar()
                BYD -> BYDCar()
                else -> object : ICar {
                    override fun doSomething() {
                        println("我是普通汽车")
                    }
                }
            }
        }
    }
}

interface ICar {
    fun doSomething()
}

class BenzCar : ICar {
    override fun doSomething() {
        println("我是奔驰")
    }
}

class BYDCar : ICar {
    override fun doSomething() {
        println("我是比亚迪")
    }
}