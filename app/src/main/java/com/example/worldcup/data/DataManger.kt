package com.example.worldcup.data

import com.example.worldcup.data.domain.Match

object DataManger {

    private val matches= mutableListOf<Match>()
    private var currentMatchIndex = 1

    // Adds a match to the matches list
    fun addMatch(match: Match){
        matches.add(match)
    }

    // Returns the current match
    fun currentMatch():Match{
        return matches[currentMatchIndex]
    }

    // Increments the currentMatchIndex and returns the next match
    fun nextMatch():Match{
        if (currentMatchIndex >= matches.size-1) return matches[currentMatchIndex]
        return matches[++currentMatchIndex]
     }

    // Decrements the currentMatchIndex and returns the previous match
    fun prevMatch():Match{
        if (currentMatchIndex <= 0) return matches[currentMatchIndex]
        return matches[--currentMatchIndex]
    }






}