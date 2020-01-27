package com.ntnu.game.states

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.ntnu.game.states.play.PlayState

class StartPageState(gsm: GameStateManager) : BaseState(gsm) {

    init {
        val btnW = SCREEN_WIDTH / 2
        val btnH = btnW / 3
        val btnPosX = (SCREEN_WIDTH - btnW) / 2
        val btnPosY = (SCREEN_HEIGHT - btnH) / 2

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
