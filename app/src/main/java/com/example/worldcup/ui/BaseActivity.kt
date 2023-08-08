package com.example.worldcup.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.MediaItem

abstract class BaseActivity< VB: ViewBinding> : AppCompatActivity() {
    protected lateinit var player: SimpleExoPlayer
    protected lateinit var playerView: PlayerView

    private var _binding: VB? = null

    protected val binding get() = _binding!!

    abstract fun getViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(requireNotNull(_binding).root)
        
        player = SimpleExoPlayer.Builder(this).build()
        playerView = findViewById(R.id.player_view)
        playerView.player = player
        
        val mediaItem = MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/play.mp3")
        player.setMediaItem(mediaItem)
        player.prepare()
    }


}