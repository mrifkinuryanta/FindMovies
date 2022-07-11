package com.dev.divig.findmovies.data.source.remote.response.tv

import com.google.gson.annotations.SerializedName

data class TvResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<TvShowsItem>,

	@field:SerializedName("total_results")
	val totalResults: Int
)

data class TvShowsItem(

	@field:SerializedName("backdrop_path")
	val backdropPath: String,

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("genre_ids")
	val genreIds: List<Int>,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("origin_country")
	val originCountry: List<String>,

	@field:SerializedName("original_language")
	val originalLanguage: String,

	@field:SerializedName("original_name")
	val originalName: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("popularity")
	val popularity: Double,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("vote_count")
	val voteCount: Int
)