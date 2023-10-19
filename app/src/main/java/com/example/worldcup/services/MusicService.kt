package com.example.worldcup.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.MediaItem

class MusicService : Service() {

    private lateinit var player: SimpleExoPlayer

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = SimpleExoPlayer.Builder(this).build()
        
    // Ensure that the URI is passed as an extra when starting the service
    val uri = intent?.getStringExtra("uri")
    if (uri == null) {
        stopSelf()
        return START_NOT_STICKY
    }
    val mediaItem = MediaItem.fromUri(uri)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()

        return START_STICKY
    }
}