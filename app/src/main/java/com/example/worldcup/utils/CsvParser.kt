package com.example.worldcup.utils

import com.example.worldcup.data.domain.Match

object CsvParser {

    fun parserLine(line :String): Match {
        val list = line.split(",")

        val year = list[Constants.MatchColumsIndex.Year]
        val stadium = list[Constants.MatchColumsIndex.Stadium]
        val homeTeamName = list[Constants.MatchColumsIndex.HomeTeamName]
        val homeTeamGoals = list[Constants.MatchColumsIndex.HomeTeamGoals]
        val awayTeam = list[Constants.MatchColumsIndex.AwayTeam]
        val awayTeamGoals = list[Constants.MatchColumsIndex.AwayTeamGoals]

        return Match(year, stadium, homeTeamName, homeTeamGoals, awayTeam, awayTeamGoals)

    }
}
