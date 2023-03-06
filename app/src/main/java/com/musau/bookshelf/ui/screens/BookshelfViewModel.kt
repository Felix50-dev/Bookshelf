package com.musau.bookshelf.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.musau.bookshelf.BookshelfApplication
import com.musau.bookshelf.data.BookshelfRepository
import com.musau.bookshelf.model.Book
import kotlinx.coroutines.launch

class BookshelfViewModel (private val bookshelfRepository: BookshelfRepository) : ViewModel() {

    /** The mutable State that stores the status of the most recent request */
    var bookShelfUiState by mutableStateOf("")
        private set

    suspend fun getBooks():List<Book> {
        return bookshelfRepository.getBooks()
    }

    init {
        viewModelScope.launch { getBooks() }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookshelfApplication)
                val bookshelfRepository = application.container.bookshelfRepository
                BookshelfViewModel(bookshelfRepository = bookshelfRepository)
            }
        }
    }

}