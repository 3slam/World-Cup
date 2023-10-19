package com.example.worldcup.ui

import android.os.Bundle
import com.example.worldcup.databinding.ActivityMusicPlayerBinding

class MusicPlayerActivity : BaseActivity<ActivityMusicPlayerBinding>() {

    override fun getViewBinding() = ActivityMusicPlayerBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.playButton.setOnClickListener {
            player.play()
        }

        binding.pauseButton.setOnClickListener {
            player.pause()
        }

    binding.nextButton.setOnClickListener {
        // Implement next functionality
        // player.next() // This method does not exist in SimpleExoPlayer
        // Replace with the correct method or implement it if necessary
    }

    binding.previousButton.setOnClickListener {
        // Implement previous functionality
        // player.previous() // This method does not exist in SimpleExoPlayer
        // Replace with the correct method or implement it if necessary
    }
    }
}