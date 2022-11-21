package com.geektech.pokemon.ui.fragments

import androidx.lifecycle.ViewModel
import com.geektech.pokemon.data.repositories.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

     fun fetchPokemon() = repository.fetchPokemon()
}