package com.example.sunrinton

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

private var mp:MediaPlayer? = null
private var currentSong:MutableList = mutableListOf(R.raw.smallking)

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)


        controlSound(currentSong[0])
    }
    private fun controlSound(Id: Int) {

        play
    }
}