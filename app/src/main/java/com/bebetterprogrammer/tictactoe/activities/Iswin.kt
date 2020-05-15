package com.bebetterprogrammer.tictactoe.activities

import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_gameplay.*

class Iswin {
    var winPosition = arrayOf(
        arrayOf(0, 1, 2), arrayOf(3, 4, 5), arrayOf(6, 7, 8), arrayOf(0, 3, 6),
        arrayOf(1, 4, 7), arrayOf(2, 5, 8), arrayOf(0, 4, 8), arrayOf(2, 4, 6)
    )
    fun iswin(ob:Gameplay): Boolean {

        var x = false
        for (winPosition in winPosition) {
            if (ob.gameState[winPosition[0]] == ob.gameState[winPosition[1]] && ob.gameState[winPosition[1]] == ob.gameState[winPosition[2]] && ob.gameState[winPosition[0]] != 2) {
                // won
                if (ob.turn == 1) {
                    if (ob.won == 0) {
                        ob.won = 1
                        var p1 = ob.p1_winning.text.toString().toInt()
                        p1++
                        ob.p1_winning.text = p1.toString()
                        ob.player1_trophy.setImageResource(R.drawable.ic_trophy_golden)
                    }
                } else {
                    if (ob.won == 0) {
                        ob.won = 1
                        var p2 = ob.p2_winning.text.toString().toInt()
                        p2++
                        ob.p2_winning.text = p2.toString()
                        ob.player2_trophy.setImageResource(R.drawable.ic_trophy_golden)
                    }
                }
                x=true
            }
        }
        return x
    }
}