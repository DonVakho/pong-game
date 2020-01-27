package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.states.BaseState

class Paddle(position: Vector2 = Vector2((BaseState.SCREEN_WIDTH - BaseState.PADDLE_WIDTH)/2, 0f),
             movement: Vector2 = Vector2(0f, 0f),
             sprite: Sprite = Sprite(Texture("paddle.png"))) : MovingObject(position, movement, sprite) {

    fun update(movement: Float) {
        if(inBounds(position.x + movement * 6)){
            position.x += movement * 6
        }
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        sb.draw(sprite,
                position.x,
                position.y,
                BaseState.PADDLE_WIDTH,
                BaseState.PADDLE_HEIGHT)
        sb.end()
    }

    private fun inBounds(pos: Float): Boolean{
        return (pos + BaseState.PADDLE_WIDTH) <= BaseState.SCREEN_WIDTH && pos >= 0
    }
}