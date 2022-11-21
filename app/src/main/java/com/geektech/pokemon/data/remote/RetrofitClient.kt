package com.geektech.pokemon.data.remote

import com.geektech.pokemon.data.remote.api.PokemonApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient: OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(provideInspector())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    private fun provideInspector(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun providePokemonApiService(): PokemonApiService {
        return retrofit.create(PokemonApiService::class.java)
    }
}