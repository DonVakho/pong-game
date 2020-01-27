package com.ntnu.game.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.ScreenViewport

abstract class BaseState(val gsm: GameStateManager) : IState {

    protected val stage: Stage = Stage(ScreenViewport())
    protected val skin = Skin(Gdx.files.internal("gdxSkins/comic/skin/comic-ui.json"))

    init {
        Gdx.input.inputProcessor = stage
    }

    protected fun createTxtButton(name: String, skin: Skin, y: Float): TextButton {
        val btnPosX = (SCREEN_WIDTH - BTN_W) / 2
        val btn = TextButton(name, skin)
        btn.setSize(BTN_W, BTN_H)
        btn.setPosition(btnPosX, y)
        return btn
    }

    protected fun createBackButton() {
        val btnPosX = (SCREEN_WIDTH - BACK_BTN_W) / 2
        val btn = TextButton("Back", skin)
        btn.setSize(BACK_BTN_W, BACK_BTN_H)
        btn.setPosition(btnPosX, SCREEN_HEIGHT / 2 - BACK_BTN_H * 2)

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


        val SCREEN_WIDTH = Gdx.graphics.width.toFloat()

        val APP_HEIGHT = Gdx.graphics.height.toFloat()

        val SCREEN_HEIGHT = APP_HEIGHT - 100

        val PADDLE_WIDTH = SCREEN_WIDTH / 4.66666666f

        const val PADDLE_HEIGHT = 20f

        const val BALL_DIAMETER = 30f

        const val NETT_WIDTH = 15f

        private val BTN_W = SCREEN_WIDTH / 2

        private val BACK_BTN_W = SCREEN_WIDTH / 5

        internal val BTN_H = BTN_W / 3

        internal val BACK_BTN_H = BTN_W / 4
    }
}