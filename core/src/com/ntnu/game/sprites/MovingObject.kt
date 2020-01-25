package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.PongGame

abstract class MovingObject(private val sprite: Sprite = Sprite(),
                            var movement: Vector2 = Vector2(0f, 0f),
                            var position: Vector2 = Vector2(0f, 0f)) {

    fun render(sb: SpriteBatch) {
        sb.begin()
        sb.draw(sprite,
                position.x,
                position.y,
                PongGame.PADDLE_WIDTH,
                PongGame.PADDLE_HEIGHT)
        sb.end()
    }
}