package com.ntnu.game.sprites

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad
import com.badlogic.gdx.scenes.scene2d.utils.DragListener
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.ntnu.game.states.BaseState

class Controllers {

    private val stage: Stage = Stage(ScreenViewport())

    var moveLow = 0

    var moveHigh = 0

    private var prevLow = 0f

    private var prevHigh = 0f

    init {

        Gdx.input.inputProcessor = stage

        val touchPadStyle = Touchpad.TouchpadStyle()
        val bgSprite = Sprite(Texture("transparent.png"))
        val knobSprite = Sprite(Texture("transparent.png"))
        val bg = SpriteDrawable(bgSprite)
        val knob = SpriteDrawable(knobSprite)
        touchPadStyle.background = bg
        touchPadStyle.knob = knob

        val touchPadLow = Touchpad(0f, touchPadStyle)
        touchPadLow.setBounds(
                -50f,
                0f,
                BaseState.SCREEN_WIDTH + 50,
                BaseState.SCREEN_HEIGHT / 2)

        val touchPadHigh = Touchpad(10f, touchPadStyle)
        touchPadHigh.setBounds(
                -50f,
                BaseState.SCREEN_HEIGHT / 2,
                BaseState.SCREEN_WIDTH + 50,
                BaseState.SCREEN_HEIGHT / 2)

        touchPadLow.addListener(object : DragListener() {
            override fun drag(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                moveLow = if (prevLow < x) 2 else -2
                prevLow = x
            }

            override fun dragStop(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                moveLow = 0
            }
        })

        touchPadHigh.addListener(object : DragListener() {
            override fun drag(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                super.drag(event, x, y, pointer)
                moveHigh = if (prevHigh < x) 2 else -2
                prevHigh = x
            }

            override fun dragStop(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                moveHigh = 0
            }
        })

        stage.addActor(touchPadLow)
        stage.addActor(touchPadHigh)
    }

    fun render() {
        stage.act()
        stage.draw()
    }

}