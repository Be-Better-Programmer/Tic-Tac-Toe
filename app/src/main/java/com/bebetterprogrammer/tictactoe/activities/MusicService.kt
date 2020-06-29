package com.bebetterprogrammer.tictactoe.activities

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.bebetterprogrammer.tictactoe.R

class MusicService : Service() {
    protected lateinit var music: MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        music = MediaPlayer.create(this, R.raw.sky_puzzle)
        music.isLooping = true
        music.setVolume(90.0f, 90.0f)
        music.start()
        return START_STICKY
    }

    override fun onDestroy() {
        music.stop()
        music.release()
        super.onDestroy()
    }
}
