package com.aiyaz.tmbdclient.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val TVShows: List<TVShow>
)