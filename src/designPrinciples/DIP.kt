package designPrinciples

import java.util.LinkedList


/**
 * Dependency Inversion Principe，依赖倒置原则。
 * 高层模块依赖底层模块是通过抽象发生的，实现类之间不直接发生依赖关系，而是通过接口或抽象类发生的。高层模块指的是调用方，
 * 底层模块指的是实现类。
 *
 * 说白了就是不要直接依赖实现，要通过接口或抽象类间接依赖，即抽象，面向接口。
 *
 * 优点：扩展性良好；当需要修改具体实现的时候，不需要修改高层依赖者的代码。
 */
class DIP {
    //直接依赖于实现，不符合依赖倒置原则
    private val arrayListCache = ArrayListCache<String>()
    //通过接口和实现类间接发生依赖，也就是符合依赖倒置原则
    private val cache = LinkedListCache<Int>()
}

interface Cache<T> {
    fun put(e: T)
    fun get(e: Int): T
}

class ArrayListCache<T> : Cache<T> {
    private val cache = mutableListOf<T>()

    override fun put(e: T) {
        cache.add(e)
    }

    override fun get(index: Int) = cache[index]
}

class LinkedListCache<T> : Cache<T> {
    private val cache = LinkedList<T>()

    override fun put(e: T) {
        cache.add(e)
    }

    override fun get(index: Int) = cache[index]
}