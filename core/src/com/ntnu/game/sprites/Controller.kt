package com.ntnu.game.sprites

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad
import com.badlogic.gdx.scenes.scene2d.utils.DragListener
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.ntnu.game.PongGame

class Controller(x: Float, y: Float) {

    private val stage: Stage = Stage(ScreenViewport())

    private var delta: Vector2 = Vector2(0f, 0f)

    init {

        Gdx.input.inputProcessor = stage

        val touchPadStyle = Touchpad.TouchpadStyle()
        val bgSprite = Sprite(Texture("transparent.png"))
        val knobSprite = Sprite(Texture("transparent.png"))
        val bg = SpriteDrawable(bgSprite)
        val knob = SpriteDrawable(knobSprite)
        touchPadStyle.background = bg
        touchPadStyle.knob = knob

        val touchPad = Touchpad(10f, touchPadStyle)
        touchPad.setBounds(
                x,
                y,
                PongGame.SCREEN_WIDTH,
                PongGame.SCREEN_HEIGHT/2)
        touchPad.addListener(object : DragListener() {
            override fun drag(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                super.drag(event, x, y, pointer)
                delta.x = touchPad.knobPercentX * 3
                delta.y = touchPad.knobPercentY * 3
            }
        })

        stage.addActor(touchPad)
    }

    fun render() {
        stage.act()
        stage.draw()
    }

    fun getDelta(): Vector2 {
        return delta
    }
}