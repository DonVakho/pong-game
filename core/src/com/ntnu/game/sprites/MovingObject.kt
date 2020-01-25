package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2

abstract class MovingObject(var position: Vector2 = Vector2(0f, 0f),
                            var movement: Vector2 = Vector2(0f, 0f),
                            protected val sprite: Sprite = Sprite()) {

    abstract fun render(sb: SpriteBatch)
}