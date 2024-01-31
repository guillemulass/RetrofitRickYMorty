package com.gmulbat1301.retrofitrickymorty.data

import com.gmulbat1301.retrofitrickymorty.data.model.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("{id}") // Parte de la url que varia en las llamadas
    fun characterInfo(
        @Path("id") id: Int, // Parametro que quiero que me introduzca el ususario, para ghacer distintas llamadas
    ) : Character // El objeto que quiero que me devuelva
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService // Me devuelve un servicio de Retofit
    {
        val baseUrl = "https://rickandmortyapi.com/api/character/" // Parte de la url que no varia en las llamadas
        println("Base URL: $baseUrl") // Comprobacion de que funciona correctamente
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()) // Le digo como quiero que me convierta la informacion de la peticion
            .build().create(RetrofitService::class.java) // Interfaz base para crear la clase que quiero
    }
}

