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
        player.next()
    }

    binding.previousButton.setOnClickListener {
        // Implement previous functionality
        player.previous()
    }
    }
}