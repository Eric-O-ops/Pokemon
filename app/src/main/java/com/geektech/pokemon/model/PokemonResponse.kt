package com.geektech.pokemon.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse <T>(

    @SerializedName("count")
    val count: Int,

    @SerializedName("next")
    val next: String?,

    @SerializedName("previous")
    val previous: String,

    @SerializedName("results")
    val results: List<T>
)
