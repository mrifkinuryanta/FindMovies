package com.dev.divig.findmovies.data.source.remote.response.tv

import com.google.gson.annotations.SerializedName

data class SpokenLanguagesItem(

	@field:SerializedName("english_name")
	val englishName: String,

	@field:SerializedName("iso_639_1")
	val iso6391: String,

	@field:SerializedName("name")
	val name: String
)