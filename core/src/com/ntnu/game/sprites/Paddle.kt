package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.PongGame

class Paddle(position: Vector2 = Vector2(0f, 0f),
             movement: Vector2 = Vector2(0f, 0f),
             sprite: Sprite = Sprite(Texture("paddle.png"))) : MovingObject(position, movement, sprite) {

    fun update(movement: Float) {
        if(inBounds(position.x + movement * 4)){
            position.x += movement * 4
        }
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        sb.draw(sprite,
                position.x,
                position.y,
                PongGame.PADDLE_WIDTH,
                PongGame.PADDLE_HEIGHT)
        sb.end()
    }

    private fun inBounds(pos: Float): Boolean{
        return (pos + PongGame.PADDLE_WIDTH) <= PongGame.SCREEN_WIDTH && pos >= 0
    }
}