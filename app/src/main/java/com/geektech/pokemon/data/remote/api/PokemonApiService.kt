package com.geektech.pokemon.data.remote.api

import com.geektech.pokemon.model.PokemonModel
import com.geektech.pokemon.model.PokemonResponse
import retrofit2.http.GET

interface PokemonApiService {

    @GET("api/v2/pokemon")
    suspend fun fetchPokemon(): PokemonResponse<PokemonModel>
}