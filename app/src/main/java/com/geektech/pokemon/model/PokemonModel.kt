package com.geektech.pokemon.model

import com.geektech.pokemon.base.IBaseDiffutil
import com.google.gson.annotations.SerializedName

data class PokemonModel(

    @SerializedName("name")
    override val name: String,

    @SerializedName("url")
    val url: String?

): IBaseDiffutil
