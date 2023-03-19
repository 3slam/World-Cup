package com.example.worldcup.data

import com.example.worldcup.data.domain.Match

object DataManger {

    private val matches= mutableListOf<Match>()
    private var currentMatchIndex = 1

    fun addMatch(match: Match){
        matches.add(match)
    }

    fun currentMatch():Match{
        return matches[currentMatchIndex]
    }

    fun nextMatch():Match{
        if (currentMatchIndex > matches.size-1) return matches[currentMatchIndex]
        return matches[++currentMatchIndex]
     }

    fun prevMatch():Match{
        if (currentMatchIndex == 0) return matches[currentMatchIndex]
        return matches[--currentMatchIndex]
    }






}