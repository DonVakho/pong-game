package com.ntnu.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.ntnu.game.PongGame

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        config.width = PongGame.SCREEN_WIDTH.toInt()
        config.height = PongGame.SCREEN_HEIGHT.toInt()
        config.title = PongGame.TITLE
        LwjglApplication(PongGame(), config)
    }
}
