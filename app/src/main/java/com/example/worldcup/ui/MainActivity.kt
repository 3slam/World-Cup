package com.example.worldcup.ui

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcup.data.DataManger
import com.example.worldcup.data.domain.Match
import com.example.worldcup.data.domain.MusicItem
import com.example.worldcup.databinding.ActivityMainBinding
import com.example.worldcup.utils.CsvParser
import com.example.worldcup.ui.MusicAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var musicRecyclerView: RecyclerView
    private lateinit var musicAdapter: MusicAdapter

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        musicRecyclerView = findViewById(R.id.music_recycler_view)
        musicAdapter = MusicAdapter()
        musicRecyclerView.adapter = musicAdapter
        fetchMusicData()
    }
    
    private fun fetchMusicData() {
        // Implement the method to fetch music data from a data source
    }

        /*

          Base Activity
          View Binding
          Domain -- data -- ui
          Buffering

         */

        parseWorldCupMatches()
        initViews(DataManger.currentMatch())
        binding.next.setOnClickListener { initViews(DataManger.nextMatch()) }
        binding.prev.setOnClickListener { initViews(DataManger.prevMatch()) }


    }

    private fun parseWorldCupMatches(){
        val matchesAsInputStream =  assets.open( "WorldCupMatches.csv")
        val buffer = BufferedReader(InputStreamReader(matchesAsInputStream))
        buffer.forEachLine {
            DataManger.addMatch(CsvParser.parserLine(it))
        }
    }

    private fun initViews(match:Match){
        binding.awayTeam.text= match.awayTeam
        binding.statuim.text= match.stadium
        binding.awayTeamGoal.text= match.awayTeamGoals
        binding.homeTeam.text= match.homeTeam
        binding.homeTeamGoals.text= match.homeTeamGoals
        binding.year.text= match.year
    }
}