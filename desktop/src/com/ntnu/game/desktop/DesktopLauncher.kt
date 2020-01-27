package com.ntnu.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.ntnu.game.PongGame

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        config.width = 350
        config.height = 600
        config.title = "Pong"
        LwjglApplication(PongGame(), config)
    }
}
