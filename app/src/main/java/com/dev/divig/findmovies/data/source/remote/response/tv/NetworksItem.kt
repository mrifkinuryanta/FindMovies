package com.dev.divig.findmovies.data.source.remote.response.tv

import com.google.gson.annotations.SerializedName

data class NetworksItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("logo_path")
	val logoPath: String,

	@field:SerializedName("origin_country")
	val originCountry: String
)