package com.ntnu.game

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
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

    private var playerLowScore = 0

    private var playerHighScore = 0

    private val scoreLabel: BitmapFont = BitmapFont()

    init {
        scoreLabel.color = Color.BLACK
    }

    fun update() {
        scoreHigh()
        scoreLow()
        wallCollision()
        paddleCollision()
        ball.update()
        paddleLow.update(controllers.moveLow.toFloat())
        paddleHigh.update(controllers.moveHigh.toFloat())
    }

    fun render(sb: SpriteBatch) {
        sb.begin()
        scoreLabel.draw(sb, "P1: $playerLowScore P2: $playerHighScore", 5f, PongGame.APP_HEIGHT - 10f)
        sb.end()
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
                && ball.position.y >= PongGame.SCREEN_HEIGHT - PongGame.PADDLE_HEIGHT * 2) {
            ball.hitPaddles()
        }
    }

    private fun scoreLow() {
        if (ball.position.y >= PongGame.SCREEN_HEIGHT) {
            playerLowScore++
            playAgain()
        }
    }

    private fun scoreHigh() {
        if (ball.position.y <= 0) {
            playerHighScore++
            playAgain()
        }
    }

    private fun playAgain() {
        ball.position.y = (PongGame.SCREEN_HEIGHT - PongGame.BALL_DIAMETER) / 2
        ball.movement.y = -ball.movement.y
    }

    fun gameOver(): Int{
        return if(playerLowScore == 5) 1 else if(playerHighScore == 5) -1 else 0
    }
}