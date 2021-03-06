package com.dev.divig.findmovies.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(

	@field:SerializedName("adult")
	val adult: Boolean,

	@field:SerializedName("backdrop_path")
	val backdropPath: String,

	@field:SerializedName("belongs_to_collection")
	val belongsToCollection: BelongsToCollection?,

	@field:SerializedName("budget")
	val budget: Int,

	@field:SerializedName("genres")
	val genres: List<GenresItem>,

	@field:SerializedName("homepage")
	val homepage: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("imdb_id")
	val imdbId: String,

	@field:SerializedName("original_language")
	val originalLanguage: String,

	@field:SerializedName("original_title")
	val originalTitle: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("popularity")
	val popularity: Double,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("production_companies")
	val productionCompanies: List<ProductionCompaniesItem>,

	@field:SerializedName("production_countries")
	val productionCountries: List<ProductionCountriesItem>,

	@field:SerializedName("release_date")
	val releaseDate: String,

	@field:SerializedName("revenue")
	val revenue: Int,

	@field:SerializedName("runtime")
	val runtime: Int,

	@field:SerializedName("spoken_languages")
	val spokenLanguages: List<SpokenLanguagesItem>,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("tagline")
	val tagline: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("video")
	val video: Boolean,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("vote_count")
	val voteCount: Int
)

data class GenresItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String
)

data class ProductionCountriesItem(

	@field:SerializedName("iso_3166_1")
	val iso31661: String,

	@field:SerializedName("name")
	val name: String
)

data class SpokenLanguagesItem(

	@field:SerializedName("english_name")
	val englishName: String,

	@field:SerializedName("iso_639_1")
	val iso6391: String,

	@field:SerializedName("name")
	val name: String
)

data class ProductionCompaniesItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("logo_path")
	val logoPath: String?,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("origin_country")
	val originCountry: String
)

data class BelongsToCollection(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("backdrop_path")
	val backdropPath: String
)