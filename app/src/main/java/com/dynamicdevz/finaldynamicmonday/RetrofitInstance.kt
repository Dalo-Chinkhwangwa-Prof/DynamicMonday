package com.dynamicdevz.finaldynamicmonday

import com.dynamicdevz.finaldynamicmonday.test.model.JikanResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RetrofitInstance {

    val jikanService = Retrofit.Builder()
        .baseUrl("https://api.jikan.moe")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(JikanService::class.java)

    interface JikanService {
        @GET("v3/search/anime")
        fun getResponse(@Query("q") search: String): Call<JikanResponse>
    }

}