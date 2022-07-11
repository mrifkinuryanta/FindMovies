package com.dev.divig.findmovies.utils

import com.dev.divig.findmovies.BuildConfig

class Constant {
    companion object {
        const val DEFAULT_DATE = "0000-00-00"
        const val EXTRA_ID = "extra_id"
        const val EXTRA_CODE = "extra_code"
        const val CODE_MOVIE = 101
        const val CODE_TV = 102

        const val ONE_HOURS = 60
        const val TEN = 10

        const val VOTE_BEST = "Best"
        const val VOTE_WORST = "Worst"
        const val VOTE_RANDOM = "Random"
        const val TB_MOVIE = "tb_movie"
        const val TB_TV_SHOW = "tb_tv_show"

        const val API_KEY = BuildConfig.api_key
        const val BASE_URL = BuildConfig.base_url
        const val IMAGE_URL = BuildConfig.image_url
    }
}