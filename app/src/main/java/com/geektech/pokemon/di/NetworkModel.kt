package com.geektech.pokemon.di

import com.geektech.pokemon.data.remote.RetrofitClient
import com.geektech.pokemon.data.remote.api.PokemonApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModel {

    @Singleton
    private val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun providePokemonApiService() = retrofitClient.providePokemonApiService()

    }