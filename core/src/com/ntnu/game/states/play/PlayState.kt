package com.ntnu.game.states.play

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.compression.lzma.Base
import com.ntnu.game.GameLogic
import com.ntnu.game.states.BaseState
import com.ntnu.game.states.GameOverState
import com.ntnu.game.states.GameStateManager
import com.ntnu.game.states.IState

class PlayState(gsm: GameStateManager)  :  BaseState(gsm) {

    private val game: GameLogic = GameLogic()

    override fun render(sb: SpriteBatch) {
        game.render(sb)
    }

    override fun update(dt: Float) {
        if(game.gameOver() == 1){
            gsm.set(GameOverState(gsm))
        }else if (game.gameOver() == -1){
            gsm.set(GameOverState(gsm))
        }
        game.update()
    }

    override fun dispose() {
    }
}