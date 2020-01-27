package com.ntnu.game

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.sprites.Ball
import com.ntnu.game.sprites.Controllers
import com.ntnu.game.sprites.Paddle
import com.ntnu.game.states.BaseState

class GameLogic {

    private val controllers: Controllers = Controllers()

    private val paddleLow: Paddle = Paddle()

    private val paddleHigh: Paddle = Paddle(Vector2(0f, BaseState.SCREEN_HEIGHT - BaseState.PADDLE_HEIGHT))

    private val ball: Ball = Ball(Vector2(100f, 200f), Vector2(7f, 8f))

    private var playerLowScore = 0

    private var playerHighScore = 0

    private val scoreLabel: BitmapFont = BitmapFont()

    init {
        scoreLabel.color = Color.BLACK
        scoreLabel.data.setScale(3f)
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
        scoreLabel.draw(sb, "P1: $playerLowScore P2: $playerHighScore", 5f, BaseState.APP_HEIGHT - 10f)
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
                (BaseState.SCREEN_HEIGHT - BaseState.NETT_WIDTH) / 2,
                BaseState.SCREEN_WIDTH,
                BaseState.NETT_WIDTH
        )
        sb.end()
    }

    private fun wallCollision() {
        if ((ball.position.x + BaseState.BALL_DIAMETER >= BaseState.SCREEN_WIDTH) || (ball.position.x <= 0f)) {
            ball.hitSideWall()
        }
    }

    private fun paddleCollision() {
        if ((ball.position.x >= paddleLow.position.x)
                && ball.position.x <= (paddleLow.position.x + (BaseState.PADDLE_WIDTH - BaseState.BALL_DIAMETER / 2))
                && ball.position.y <= 0 + BaseState.PADDLE_HEIGHT) {
            ball.hitPaddles()
        } else if ((ball.position.x >= paddleHigh.position.x)
                && ball.position.x <= (paddleHigh.position.x + (BaseState.PADDLE_WIDTH - BaseState.BALL_DIAMETER / 2))
                && ball.position.y >= BaseState.SCREEN_HEIGHT - BaseState.PADDLE_HEIGHT * 2) {
            ball.hitPaddles()
        }
    }

    private fun scoreLow() {
        if (ball.position.y >= BaseState.SCREEN_HEIGHT) {
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
        ball.position.y = (BaseState.SCREEN_HEIGHT - BaseState.BALL_DIAMETER) / 2
        ball.movement.y = -ball.movement.y
    }

    fun gameOver(): Int{
        return if(playerLowScore == 3) 1 else if(playerHighScore == 3) -1 else 0
    }
}