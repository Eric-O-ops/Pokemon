package com.geektech.pokemon.ui.fragments

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.pokemon.R
import com.geektech.pokemon.base.BaseFragment
import com.geektech.pokemon.common.Resource
import com.geektech.pokemon.databinding.FragmentPokemonBinding
import com.geektech.pokemon.ui.adapters.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonFragment :
    BaseFragment<FragmentPokemonBinding, PokemonViewModel>(R.layout.fragment_pokemon) {

    override val binding by viewBinding(FragmentPokemonBinding::bind)
    override val viewModel: PokemonViewModel by viewModels()
    private val pokemonAdapter = PokemonAdapter()

    override fun initialize() {
        with(binding.pokemonRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pokemonAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchPokemon().observe(viewLifecycleOwner) {
            when(it) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {}

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    pokemonAdapter.submitList(it.data?.results)
                }
            }
        }
    }
}