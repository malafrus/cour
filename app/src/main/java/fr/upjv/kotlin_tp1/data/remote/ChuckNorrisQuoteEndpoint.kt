package fr.upjv.kotlin_tp1.data.remote

import fr.upjv.kotlin_tp1.data.model.ChuckNorrisDto
import retrofit2.http.GET


interface ChuckNorrisQuoteEndpoint {


    @GET("random")
    suspend fun getRandomQuote() : ChuckNorrisDto
}
