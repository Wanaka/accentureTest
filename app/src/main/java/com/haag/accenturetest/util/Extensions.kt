package com.haag.accenturetest.util

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.lineDivider() {
    this.addItemDecoration(
        DividerItemDecoration(
            this.context,
            DividerItemDecoration.VERTICAL
        )
    )
}

fun region(region: String): String {
    return when (region) {
        "The North" -> "https://bit.ly/2Gcq0r4"
        "The Vale" -> "https://bit.ly/34FAvws"
        "The Riverlands" -> "https://bit.ly/3kJrIiP"
        "Iron Islands" -> "https://bit.ly/3kJrIiP"
        "The Westerlands" -> "https://bit.ly/2TAzjnO"
        "The Reach" -> "https://bit.ly/2HSCW5N"
        "Dorne" -> "https://bit.ly/2HOcavT"
        "The Stormlands" -> "https://bit.ly/34F2sEC"
        else -> ""
    }
}
