package com.dev.divig.findmovies.data.source.local.entity

data class DetailEntity(
    var id: Int,
    var title: String,
    var overview: String,
    var genres: List<String>,
    var releaseDate: String,
    var runtime: Int,
    var voteAverage: Double,
    var posterPath: String,
    var backdropPath: String
)
