package com.ntnu.game.states

import com.badlogic.gdx.graphics.g2d.SpriteBatch

interface IState {
    
    fun render(sb: SpriteBatch)

    fun update(dt: Float)

    fun dispose()
}
