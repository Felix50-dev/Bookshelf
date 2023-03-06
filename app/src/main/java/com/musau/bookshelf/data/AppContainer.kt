package com.musau.bookshelf.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.musau.bookshelf.network.BooksApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer

class BooksAppContainer: AppContainer {

    private val url = "https://www.googleapis.com/books/v1/volumes?q=cicero"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(url)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
}