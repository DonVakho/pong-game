package com.ntnu.game.states.play

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.ntnu.game.GameLogic
import com.ntnu.game.states.GameStateManager
import com.ntnu.game.states.IState

class PlayState(gsm: GameStateManager)  : IState {

    private val game: GameLogic = GameLogic()

    override fun render(sb: SpriteBatch) {
        game.render(sb)
    }

    override fun update(dt: Float) {
        game.update()
    }

    override fun dispose() {
    }
}