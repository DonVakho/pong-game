package com.ntnu.game.states

import com.badlogic.gdx.graphics.g2d.SpriteBatch

import java.util.Stack

class GameStateManager {

    private val states: Stack<IState> = Stack()

    fun push(state: IState) {
        states.push(state)
    }

    fun pop() {
        states.pop().dispose()
    }

    fun set(state: IState) {
        states.pop().dispose()
        states.push(state)
    }

    fun update(dt: Float) {
        states.peek().update(dt)
    }

    fun render(sb: SpriteBatch) {
        states.peek().render(sb)
    }
}
