package com.bebetterprogrammer.tictactoe.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bebetterprogrammer.tictactoe.BuildConfig
import com.bebetterprogrammer.tictactoe.R
import kotlinx.android.synthetic.main.activity_play_with_jarvis.*

class PlayWithJarvisActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_with_jarvis)

        val versionName = BuildConfig.VERSION_NAME
        appBottomLine.text = "Designed @ bebetterprogrammer.com | v$versionName"

        var flag: Int = 0
        var flag1: Int = 0
        var flag2: Int = 0

        diff_low.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
        weapon_circle.setImageResource(R.drawable.ic_circle_secondary)
        circle_move.setImageResource(R.drawable.ic_circle_secondary)

        diff_low.setOnClickListener(View.OnClickListener {
            diff_low.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
            diff_medium.setBackgroundResource(R.drawable.layout_difficulty_button)
            diff_high.setBackgroundResource(R.drawable.layout_difficulty_button)
            flag = 0
        })
        diff_medium.setOnClickListener(View.OnClickListener {
            diff_low.setBackgroundResource(R.drawable.layout_difficulty_button)
            diff_medium.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
            diff_high.setBackgroundResource(R.drawable.layout_difficulty_button)
            flag = 1
        })
        diff_high.setOnClickListener(View.OnClickListener {
            diff_low.setBackgroundResource(R.drawable.layout_difficulty_button)
            diff_medium.setBackgroundResource(R.drawable.layout_difficulty_button)
            diff_high.setBackgroundResource(R.drawable.layout_difficulty_button_secondary)
            flag = 2
        })

        weapon_circle.setOnClickListener(View.OnClickListener {
            weapon_circle.setImageResource(R.drawable.ic_circle_secondary)
            weapon_cross.setImageResource(R.drawable.ic_cross_white)
            flag1 = 0
        })
        weapon_cross.setOnClickListener(View.OnClickListener {
            weapon_circle.setImageResource(R.drawable.ic_circle_white)
            weapon_cross.setImageResource(R.drawable.ic_cross_secondary)
            flag1 = 1
        })
        circle_move.setOnClickListener(View.OnClickListener {
            circle_move.setImageResource(R.drawable.ic_circle_secondary)
            cross_move.setImageResource(R.drawable.ic_cross_white)
            flag2 = 0
        })
        cross_move.setOnClickListener(View.OnClickListener {
            circle_move.setImageResource(R.drawable.ic_circle_white)
            cross_move.setImageResource(R.drawable.ic_cross_secondary)
            flag2 = 1
        })

        btnPlay.setOnClickListener(View.OnClickListener {
            moveFirst(flag, flag1, flag2)
        })
        btnQuit.setOnClickListener(View.OnClickListener {
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
        finish()
    }
}
