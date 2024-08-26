package programmerzamannow.belajarandroiddasar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var computerImageView: ImageView
    lateinit var rockImageButton: ImageButton
    lateinit var scissorsImageButton: ImageButton
    lateinit var paperImageButton: ImageButton
    lateinit var resultImageView: ImageView
    lateinit var nextButton: Button

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        resultImageView = findViewById(R.id.resultImageView)
        nextButton = findViewById(R.id.nextButton)
    }

    private fun initListener() {
        rockImageButton.setOnClickListener { startGame("ROCK") }
        scissorsImageButton.setOnClickListener { startGame("SCISSORS") }
        paperImageButton.setOnClickListener { startGame("PAPER") }
        nextButton.setOnClickListener { changeActivity() }
    }

    private fun startGame(option: String) {
        val computerOption = Game.picRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when {
            Game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(option, computerOption) -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }
    }

    private fun changeActivity() {
        val intent = Intent(this@GameActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListener()

    }

}