package com.dev.divig.findmovies.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object SortUtils {

    fun getSortedQuery(filter: String, table_name: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM $table_name ")
        when (filter) {
            Constant.VOTE_BEST -> simpleQuery.append("ORDER BY voteAverage DESC")
            Constant.VOTE_WORST -> simpleQuery.append("ORDER BY voteAverage ASC")
            Constant.VOTE_RANDOM -> simpleQuery.append("ORDER BY RANDOM()")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}