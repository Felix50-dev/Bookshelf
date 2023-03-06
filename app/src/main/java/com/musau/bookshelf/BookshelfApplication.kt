package com.musau.bookshelf

import android.app.Application
import com.musau.bookshelf.data.AppContainer
import com.musau.bookshelf.data.BooksAppContainer

class BookshelfApplication: Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = BooksAppContainer()
    }
}