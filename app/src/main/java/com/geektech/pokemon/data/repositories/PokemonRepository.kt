package com.geektech.pokemon.data.repositories

import androidx.lifecycle.liveData
import com.geektech.pokemon.common.Resource
import com.geektech.pokemon.data.remote.api.PokemonApiService
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonApiService: PokemonApiService
) {

    fun fetchPokemon() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(pokemonApiService.fetchPokemon()))
        } catch (exception: Exception) {
            emit(Resource.Error(massage = exception.localizedMessage ?: "Error"))
        }
    }
}