package behaviorPatter.state

fun main() {
    val wiFiController = WiFiController()
    wiFiController.apply {
        openWiFi()
        scanWiFi()
        connectWiFi()

        closeWiFi()
        scanWiFi()
        connectWiFi()
    }
}

/**
 * 状态模式
 *
 * 当一个对象的状态改变时，所表现出的行为也会随之改变，它适用于需要在运行时动态改变状态的场景，
 * 能够通过多态的方式，将对象的行为封装到不同的状态对象之后，从而简化分支语句。
 *
 * 优点：符合开放封闭原则，扩展性良好
 * 缺点：增加类和对象的个数
 */

interface IWiFiState {
    fun scanWiFi()

    fun connectWiFi()
}

class OpenState : IWiFiState {
    override fun scanWiFi() {
        println("开始扫描可用WiFi")
    }

    override fun connectWiFi() {
        println("开始连接WiFi")
    }
}

class CloseState : IWiFiState {
    override fun scanWiFi() {
        println("别看我，我可扫描不了WiFi")
    }

    override fun connectWiFi() {
        println("别看我，我可连接不了WiFi")
    }
}

interface ISettingsController {
    fun openWiFi()
    fun closeWiFi()
}

class WiFiController(private var wiFiState: IWiFiState = CloseState()) : ISettingsController {

    override fun openWiFi() {
        wiFiState = OpenState()
        println("打开WiFi")
    }

    override fun closeWiFi() {
        wiFiState = CloseState()
        println("关闭WiFi")
    }

    fun scanWiFi() = wiFiState.scanWiFi()

    fun connectWiFi() = wiFiState.connectWiFi()
}