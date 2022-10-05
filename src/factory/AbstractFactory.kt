package factory

fun main() {
    val androidFactory = AndroidFactory()
    androidFactory.developDialerApp().makeACall()
    androidFactory.developMessageApp().sendMessage()

    val iOSFactory = iOSFactory()
    iOSFactory.developDialerApp().makeACall()
    iOSFactory.developMessageApp().sendMessage()
}

/**
 * 抽象工厂和工厂方法模式的区别就在于抽象工厂中生产某一类相关或者相互依赖的产品，而不是某一类的产品。
 * 例如：某一工厂生产拨号软件和短信软件，而有Android、iOS、Windows Phone等平台需要开发拨号软件和短信软件，因此可以在抽象工厂中提供创建
 * 拨号软件和短信软件的抽象方法
 */
abstract class SoftwareFactory {
    abstract fun developDialerApp(): DialerApp

    abstract fun developMessageApp(): MessageApp
}

class AndroidFactory : SoftwareFactory() {
    override fun developDialerApp(): DialerApp {
        return AndroidDialerApp()
    }

    override fun developMessageApp(): MessageApp {
        return AndroidMessageApp()
    }
}

class iOSFactory : SoftwareFactory() {
    override fun developDialerApp(): DialerApp {
        return iOSDialerApp()
    }

    override fun developMessageApp(): MessageApp {
        return iOSMessageApp()
    }
}

abstract class DialerApp {
    abstract fun makeACall()
}

abstract class MessageApp {
    abstract fun sendMessage()
}

class AndroidDialerApp : DialerApp() {
    override fun makeACall() {
        println("Android设备打电话")
    }
}

class iOSDialerApp : DialerApp() {
    override fun makeACall() {
        println("iOS设备打电话")
    }
}

class AndroidMessageApp : MessageApp() {
    override fun sendMessage() {
        println("Android设备发信息")
    }
}

class iOSMessageApp : MessageApp() {
    override fun sendMessage() {
        println("iOS设备发信息")
    }
}