package com.ntnu.game.states

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.ntnu.game.states.play.PlayState

class GameOverState(gsm: GameStateManager, winner: Int) : BaseState(gsm) {

    private val winnerLabel: BitmapFont = BitmapFont()

    private val layout = GlyphLayout()

    init {
        winnerLabel.color = Color.BLACK
        winnerLabel.data.setScale(3.5f)
        layout.setText(winnerLabel, "Player: $winner won")
        val playAgain = createTxtButton("Play Again", skin, SCREEN_HEIGHT / 2)
        playAgain.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.push(PlayState(gsm))
            }
        })

        createBackButton()

        stage.addActor(playAgain)
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        winnerLabel.draw(sb, layout, (SCREEN_WIDTH - layout.width) / 2, APP_HEIGHT - 500f)
        sb.end()
        super.render(sb)
    }

    override fun update(dt: Float) {}

    override fun dispose() {}


}