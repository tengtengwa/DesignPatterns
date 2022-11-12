package behaviorPatter.strategy

fun main() {
    val calculator = PriceCalculator().apply {
        strategy = TaxiStrategy()
    }
    println(calculator.calculatePrice(10))

    calculator.strategy = BusStrategy()
    println(calculator.calculatePrice(10))
}

/**
 * 策略模式
 * 行为型设计模式，一个类的行为或算法可以在运行时更改。
 * Context类持有一个策略类对象，其中通过多态调用具体策略类的方法来实现不同的行为。
 *
 * 优点：符合开放封闭原则，扩展性良好
 * 缺点：增加新的策略类时需要新增类
 */

class PriceCalculator {
    lateinit var strategy: IStrategy

    fun calculatePrice(km: Int): Int {
        return strategy.calculatePrice(km)
    }
}

interface IStrategy {
    fun calculatePrice(km: Int): Int
}

class BusStrategy : IStrategy {
    override fun calculatePrice(km: Int): Int {
        return if (km <= 5) {
            10
        } else if (km <= 10) {
            12
        } else {
            15
        }
    }
}

class TaxiStrategy : IStrategy {
    override fun calculatePrice(km: Int) = km * 2
}