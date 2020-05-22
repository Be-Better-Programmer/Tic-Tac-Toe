package com.bebetterprogrammer.tictactoe.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bebetterprogrammer.tictactoe.BuildConfig
import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_play_with_friend.*

class PlayWithJarvisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_with_jarvis)

        var flag: Int = 0
        var flag1: Int = 0
        var flag2: Int = 0
        val versionName = BuildConfig.VERSION_NAME
        appBottomLine.text = "Designed @ bebetterprogrammer.com | v$versionName"

        val low = findViewById<Button>(R.id.diff_low)
        val medium = findViewById<Button>(R.id.diff_medium)
        val high = findViewById<Button>(R.id.diff_high)

        val wepCircle = findViewById<ImageButton>(R.id.wepon_circle)
        val wepCross = findViewById<ImageButton>(R.id.wepon_cross)
        val moveCircle = findViewById<ImageButton>(R.id.circle_move)
        val moveCross = findViewById<ImageButton>(R.id.cross_move)

        val play = findViewById<TextView>(R.id.btnPlay)
        val quit = findViewById<TextView>(R.id.btnQuit)

        low.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
        wepCircle.setImageResource(R.drawable.ic_circle_secondary)
        moveCircle.setImageResource(R.drawable.ic_circle_secondary)

        low.setOnClickListener(View.OnClickListener {
            low.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
            medium.setBackgroundResource(R.drawable.layout_difficulty_button)
            high.setBackgroundResource(R.drawable.layout_difficulty_button)
            flag = 0
        })
        medium.setOnClickListener(View.OnClickListener {
            low.setBackgroundResource(R.drawable.layout_difficulty_button)
            medium.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
            high.setBackgroundResource(R.drawable.layout_difficulty_button)
            flag = 1
        })
        high.setOnClickListener(View.OnClickListener {
            low.setBackgroundResource(R.drawable.layout_difficulty_button)
            medium.setBackgroundResource(R.drawable.layout_difficulty_button)
            high.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
            flag = 2
        })

        wepCircle.setOnClickListener(View.OnClickListener {
            wepCircle.setImageResource(R.drawable.ic_circle_secondary)
            wepCross.setImageResource(R.drawable.ic_cross_white)
            flag1 = 0
        })
        wepCross.setOnClickListener(View.OnClickListener {
            wepCircle.setImageResource(R.drawable.ic_circle_white)
            wepCross.setImageResource(R.drawable.ic_cross_secondary)
            flag1 = 1
        })
        moveCircle.setOnClickListener(View.OnClickListener {
            moveCircle.setImageResource(R.drawable.ic_circle_secondary)
            moveCross.setImageResource(R.drawable.ic_cross_white)
            flag2 = 0
        })
        moveCross.setOnClickListener(View.OnClickListener {
            moveCircle.setImageResource(R.drawable.ic_circle_white)
            moveCross.setImageResource(R.drawable.ic_cross_secondary)
            flag2 = 1
        })

        play.setOnClickListener(View.OnClickListener {
            moveFirst(flag, flag1, flag2)
        })
        quit.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun moveFirst(flag: Int, flag1: Int, flag2: Int) {
        val intent = Intent(this, GamePlayActivity::class.java)
        intent.putExtra("Flag", flag) // flag for difficulty level
        intent.putExtra("Flag1", flag1) // Player Weapon
        intent.putExtra("Flag2", flag2) // Who will move first
        intent.putExtra("vsWhom", 1) // Vs Jarvis
        startActivity(intent)
    }
}