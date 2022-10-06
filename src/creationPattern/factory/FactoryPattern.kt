package creationPattern.factory


fun main() {
    val bananaFactory = BananaFactory()
    val banana = bananaFactory.createFruit()
    banana.toBeEaten()

    val appleFactory = AppleFactory()
    val apple = appleFactory.createFruit()
    apple.toBeEaten()

    //反射方式创建对象的工厂
    val factory = ConcreteFruitFactory()
    val app = factory.createFruit(Apple::class.java)
    app.toBeEaten()
    val bana = factory.createFruit(Banana::class.java)
    bana.toBeEaten()
}

/**
 * 工厂方法模式，创建型设计模式之一。用于定义一个创建对象的接口，让子类来决定实例化哪个类。
 *
 * 简单工厂、工厂方法、抽象工厂的区别：
 *
 * 简单工厂：只有一个具体的工厂，和一个抽象产品+它的具体产品类，适用于产品较少，几乎不需要扩展的场景。通过工厂中的静态方法来创建对象。
 * 工厂方法：一个抽象工厂，和一个抽象产品，通过多态来创建具体的产品类，适用于一个类型的多个产品。
 * 抽象工厂：一个抽象工厂，和多个抽象产品，对产品子类进行分组，根据多态来创建具体的产品类，适用于多个类型的多个产品。
 *
 * 工厂模式的使用应该根据具体的业务场景来选择使用具体哪一种工厂，也就是说：没有最好的模式，只有最合适的模式。
 */

interface IFruitFactory {
    fun createFruit(): IFruit
}

interface IFruit {
    fun toBeEaten()
}

class BananaFactory : IFruitFactory {
    override fun createFruit() = Banana()
}

class AppleFactory : IFruitFactory {
    override fun createFruit() = Apple()
}

class Banana : IFruit {
    override fun toBeEaten() {
        println("香蕉被吃了")
    }
}

class Apple : IFruit {
    override fun toBeEaten() {
        println("苹果被吃了")
    }
}

/**
 * 利用反射的方式来创建产品对象：
 */
interface FruitFactory {
    fun <T : IFruit> createFruit(clz: Class<T>): T?
}

class ConcreteFruitFactory : FruitFactory {
    override fun <T : IFruit> createFruit(clz: Class<T>): T {
        var fruit: IFruit? = null
        try {
            fruit = Class.forName(clz.name).newInstance() as IFruit
        } catch (e: java.lang.Exception) {
        }
        fruit as? T ?: throw IllegalStateException("fruit 为空！")
        return fruit
    }
}