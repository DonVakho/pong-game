package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2

class Ball(sprite: Sprite = Sprite(),
           movement: Vector2 = Vector2(0f, 0f),
           position: Vector2 = Vector2(0f, 0f)) : MovingObject(sprite, movement, position) {
}