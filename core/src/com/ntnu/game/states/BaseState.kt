package com.ntnu.game.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.ntnu.game.PongGame

abstract class BaseState(val gsm: GameStateManager) : IState {

    protected val stage: Stage = Stage(ScreenViewport())
    protected val skin = Skin(Gdx.files.internal("gdxSkins/comic/skin/comic-ui.json"))

    init {
        Gdx.input.inputProcessor = stage
    }

    protected fun createTxtButton(name: String, skin: Skin, y: Float): TextButton {
        val btnPosX = (PongGame.SCREEN_WIDTH - BTN_W) / 2
        val btn = TextButton(name, skin)
        btn.setSize(BTN_W, BTN_H)
        btn.setPosition(btnPosX, y)
        return btn
    }

    protected fun createBackButton() {
        val btnPosX = (PongGame.SCREEN_WIDTH - BACK_BTN_W) / 2
        val btn = TextButton("Back", skin)
        btn.setSize(BACK_BTN_W, BACK_BTN_H)
        btn.setPosition(btnPosX, PongGame.SCREEN_HEIGHT / 2 - BACK_BTN_H * 2)

        btn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(StartPageState(gsm))
            }
        })
        stage.addActor(btn)
    }

    override fun render(sb: SpriteBatch) {
        stage.act()
        stage.draw()
    }

    companion object {

        private const val BTN_W = PongGame.SCREEN_WIDTH / 2
        private const val BACK_BTN_W = PongGame.SCREEN_WIDTH / 5

        internal const val BTN_H = BTN_W / 3
        internal const val BACK_BTN_H = BTN_W / 4
    }
}