package com.musau.bookshelf.ui.screens

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.musau.bookshelf.R
import com.musau.bookshelf.model.Book

@Composable
fun BooksGrid(books: List<Book>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(items = books, key = { book -> book.id }) { book ->
            BooksPhotoCard(book)
        }
    }
}

@Composable
fun BooksPhotoCard(book: Book, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .aspectRatio(1f),
        elevation = 8.dp,
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(book.imageUrl)
                .crossfade(true)
                .build(),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.book_photo),
            contentScale = ContentScale.FillBounds,
        )
    }
}