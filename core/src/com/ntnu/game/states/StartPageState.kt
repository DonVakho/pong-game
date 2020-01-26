package com.ntnu.game.states

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.ntnu.game.PongGame
import com.ntnu.game.states.play.PlayState

class StartPageState(gsm: GameStateManager) : BaseState(gsm) {

    init {
        val btnW = PongGame.SCREEN_WIDTH / 2
        val btnH = btnW / 3
        val btnPosX = (PongGame.SCREEN_WIDTH - btnW) / 2
        val btnPosY = (PongGame.SCREEN_HEIGHT - btnH) / 2

        val playBtn = TextButton("Play", skin)
        playBtn.setSize(btnW, btnH)
        playBtn.setPosition(btnPosX, btnPosY)
        playBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(PlayState(gsm))
            }
        })

        stage.addActor(playBtn)
    }

    override fun render(sb: SpriteBatch) {
        stage.act()
        stage.draw()
    }

    override fun update(dt: Float) {}

    override fun dispose() {
    }
}
