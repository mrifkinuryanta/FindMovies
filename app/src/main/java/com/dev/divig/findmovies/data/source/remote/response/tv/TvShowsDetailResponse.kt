package com.dev.divig.findmovies.data.source.remote.response.tv

import com.google.gson.annotations.SerializedName

data class TvShowsDetailResponse(

	@field:SerializedName("backdrop_path")
	val backdropPath: String,

	@field:SerializedName("created_by")
	val createdBy: List<CreatedByItem>,

	@field:SerializedName("episode_run_time")
	val episodeRunTime: List<Int>,

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("genres")
	val genres: List<GenresItem>,

	@field:SerializedName("homepage")
	val homepage: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("in_production")
	val inProduction: Boolean,

	@field:SerializedName("languages")
	val languages: List<String>,

	@field:SerializedName("last_air_date")
	val lastAirDate: String,

	@field:SerializedName("last_episode_to_air")
	val lastEpisodeToAir: LastEpisodeToAir,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("next_episode_to_air")
	val nextEpisodeToAir: NextEpisodeToAir?,

	@field:SerializedName("networks")
	val networks: List<NetworksItem>,

	@field:SerializedName("number_of_episodes")
	val numberOfEpisodes: Int,

	@field:SerializedName("number_of_seasons")
	val numberOfSeasons: Int,

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

	@field:SerializedName("production_companies")
	val productionCompanies: List<ProductionCompaniesItem>,

	@field:SerializedName("production_countries")
	val productionCountries: List<ProductionCountriesItem>,

	@field:SerializedName("seasons")
	val seasons: List<SeasonsItem>,

	@field:SerializedName("spoken_languages")
	val spokenLanguages: List<SpokenLanguagesItem>,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("tagline")
	val tagline: String,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("vote_count")
	val voteCount: Int
)