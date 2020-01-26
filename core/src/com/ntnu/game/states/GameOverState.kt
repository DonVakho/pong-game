package com.ntnu.game.states

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.ntnu.game.PongGame
import com.ntnu.game.states.play.PlayState

class GameOverState(gsm: GameStateManager) : BaseState(gsm) {
    init {

        val playAgain = createTxtButton("Play Again", skin, PongGame.SCREEN_HEIGHT / 2)
        playAgain.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.push(PlayState(gsm))
            }
        })

        createBackButton()

        stage.addActor(playAgain)
    }

    override fun update(dt: Float) {}

    override fun dispose() {}


}