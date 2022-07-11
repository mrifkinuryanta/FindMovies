package com.dev.divig.findmovies.data.source.remote.response.tv

import com.google.gson.annotations.SerializedName

data class GenresItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String
)