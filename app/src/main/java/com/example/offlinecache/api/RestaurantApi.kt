package com.example.offlinecache.api

import com.example.offlinecache.data.Restaurant
import retrofit2.http.GET

interface RestaurantApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<Restaurant>
}