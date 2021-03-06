package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.states.BaseState

class Ball(position: Vector2 = Vector2(0f, 0f),
           movement: Vector2 = Vector2(0f, 0f),
           sprite: Sprite = Sprite(Texture("ball.png"))) : MovingObject(position, movement, sprite) {

    fun update() {
        position.add(movement)
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        sb.draw(sprite,
                position.x,
                position.y,
                BaseState.BALL_DIAMETER,
                BaseState.BALL_DIAMETER)
        sb.end()
    }

    fun hitSideWall() {
        movement.x = -movement.x
    }

    fun hitPaddles() {
        movement.y = -movement.y
    }


}