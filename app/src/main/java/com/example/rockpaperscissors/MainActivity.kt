package com.example.rockpaperscissors

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRock.setOnClickListener(this)
        btnPaper.setOnClickListener(this)
        btnScissors.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when(view!!.id) {
            R.id.btnRock -> {
                val a = cpuRandomChoose()
                tvPlayerChoosed.text = "You choosed: ${btnRock.text}"
                tvCupChoosed.text = "CPU choosed: $a"
                tvWhoWin.text = whoWin(btnRock.text.toString(), a)

                if(tvWhoWin.text == "You win") {
                    var b = tvPlayerScore.text.toString().toInt()
                    b += 1
                    tvPlayerScore.text = b.toString()

                } else if(tvWhoWin.text == "You lose") {
                    var b = tvCupScore.text.toString().toInt()
                    b += 1
                    tvCupScore.text = b.toString()
                }
            }

            R.id.btnPaper -> {
                val a = cpuRandomChoose()
                tvPlayerChoosed.text = "You choosed ${btnPaper.text}"
                tvCupChoosed.text = "CPU choosed: $a"
                tvWhoWin.text = whoWin(btnRock.text.toString(), cpuRandomChoose())

                if(tvWhoWin.text == "You win") {
                    var b = tvPlayerScore.text.toString().toInt()
                    b += 1
                    tvPlayerScore.text = b.toString()
                } else if(tvWhoWin.text == "You lose") {
                    var b = tvCupScore.text.toString().toInt()
                    b += 1
                    tvCupScore.text = b.toString()
                }
            }

            R.id.btnScissors -> {
                val a = cpuRandomChoose()
                tvPlayerChoosed.text = "You choosed ${btnScissors.text}"
                tvCupChoosed.text = "CPU choosed: $a"
                tvWhoWin.text = whoWin(btnRock.text.toString(), cpuRandomChoose())

                if(tvWhoWin.text == "You win") {
                    var b = tvPlayerScore.text.toString().toInt()
                    b += 1
                    tvPlayerScore.text = b.toString()
                } else if(tvWhoWin.text == "You lose") {
                    var b = tvCupScore.text.toString().toInt()
                    b += 1
                    tvCupScore.text = b.toString()
                }
            }
        }
    }
}

fun whoWin(playerChoosed: String, cpuChoosed: String): String {
    var result = ""
    if(playerChoosed == "Rock" && cpuChoosed == "Rock") {
        result = "It's a Draw"
    } else if (playerChoosed == "Rock" && cpuChoosed == "Paper") {
        result =  "You lose"
    } else if(playerChoosed == "Rock" && cpuChoosed == "Scissors") {
        result =  "You win"
    } else if(playerChoosed == "Paper" && cpuChoosed == "Rock") {
        result =  "You win"
    } else if(playerChoosed == "Paper" && cpuChoosed == "Paper") {
        result =  "It's a Draw"
    } else if(playerChoosed == "Paper" && cpuChoosed == "Scissors") {
        result =  "You lose"
    } else if(playerChoosed == "Scissors" && cpuChoosed == "Rock") {
        result =  "You lose"
    } else if(playerChoosed == "Scissors" && cpuChoosed == "Paper") {
        result =  "You win"
    } else if(playerChoosed == "Scissors" && cpuChoosed == "Scissors") {
        result =  "It's a Draw"
    }
    return result
}

fun cpuRandomChoose(): String {
    val rockPaperScissors = arrayOf("Rock", "Paper", "Scissors")
    return rockPaperScissors[(0..2).random()]
}
