package com.ntnu.game

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.sprites.Ball
import com.ntnu.game.sprites.Controllers
import com.ntnu.game.sprites.Paddle

class GameLogic {

    private val controllers: Controllers = Controllers()

    private val paddleLow: Paddle = Paddle()

    private val paddleHigh: Paddle = Paddle(Vector2(0f, PongGame.SCREEN_HEIGHT - PongGame.PADDLE_HEIGHT))

    private val ball: Ball = Ball(Vector2(100f, 200f), Vector2(2f, 2f))

    fun update() {
        wallCollision()
        paddleCollision()
        ball.update()
        paddleLow.update(controllers.moveLow.toFloat())
        paddleHigh.update(controllers.moveHigh.toFloat())
    }

    fun render(sb: SpriteBatch) {
        renderNet(sb)
        controllers.render()
        paddleLow.render(sb)
        paddleHigh.render(sb)
        ball.render(sb)
    }

    private fun renderNet(sb: SpriteBatch) {
        val netTexture = Texture("nett.png")
        sb.begin()
        sb.draw(netTexture,
                0f,
                (PongGame.SCREEN_HEIGHT - PongGame.NETT_WIDTH) / 2,
                PongGame.SCREEN_WIDTH,
                PongGame.NETT_WIDTH
        )
        sb.end()
    }

    private fun wallCollision() {
        if ((ball.position.x + PongGame.BALL_DIAMETER >= PongGame.SCREEN_WIDTH) || (ball.position.x <= 0f)) {
            ball.hitSideWall()
        }
    }

    private fun paddleCollision() {
        if ((ball.position.x >= paddleLow.position.x)
                && ball.position.x <= (paddleLow.position.x + (PongGame.PADDLE_WIDTH - PongGame.BALL_DIAMETER / 2))
                && ball.position.y <= 0 + PongGame.PADDLE_HEIGHT) {
            ball.hitPaddles()
        } else if ((ball.position.x >= paddleHigh.position.x)
                && ball.position.x <= (paddleHigh.position.x + (PongGame.PADDLE_WIDTH - PongGame.BALL_DIAMETER / 2))
                && ball.position.y >= PongGame.SCREEN_HEIGHT - PongGame.PADDLE_HEIGHT*2){
            ball.hitPaddles()
        }
    }
}