package com.coderbot.follower.presentation.common_views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> GridView(
    items: MutableList<T>,
    colSpan: Int = 2,
    itemContent: @Composable (T) -> Unit
) {
    val rows = items.chunked(colSpan)
    LazyColumn {
        items(rows) { row ->
            Row(Modifier.fillParentMaxWidth()) {
                for ((index, item) in row.withIndex()) {
                    Box(Modifier.fillMaxWidth(1f / (colSpan - index)).padding(7.dp)) {
                        itemContent(item)
                    }
                }
            }
        }
    }
}