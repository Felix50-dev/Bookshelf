package com.musau.bookshelf.network

import com.musau.bookshelf.model.Book

interface BooksApiService {

    suspend fun getBooks(): List<Book>
}