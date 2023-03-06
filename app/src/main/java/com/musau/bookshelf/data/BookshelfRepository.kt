package com.musau.bookshelf.data

import com.musau.bookshelf.model.Book
import com.musau.bookshelf.network.BooksApiService

interface BookshelfRepository {

    suspend fun getBooks(): List<Book>

    class DefaultBookShelfRepository(private val booksApiService: BooksApiService) :
        BookshelfRepository {

        override suspend fun getBooks(): List<Book> {
            return booksApiService.getBooks()
        }

    }
}