package com.bebetterprogrammer.tictactoe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        startService(Intent(this@BaseActivity, MusicService::class.java))
    }

    override fun onStop() {
        super.onStop()
        stopService(Intent(this@BaseActivity, MusicService::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(Intent(this@BaseActivity, MusicService::class.java))
    }
}
