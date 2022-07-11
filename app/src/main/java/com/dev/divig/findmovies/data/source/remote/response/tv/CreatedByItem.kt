package com.dev.divig.findmovies.data.source.remote.response.tv

import com.google.gson.annotations.SerializedName

data class CreatedByItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("credit_id")
	val creditId: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("gender")
	val gender: Int,

	@field:SerializedName("profile_path")
	val profilePath: String
)