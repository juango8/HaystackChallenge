package com.juango.haystackchallenge.model

data class Card(
    var title: String? = "",
    val author: String = "",
    val date: String = "",
    val imageUrl: String? = null,
    val localImageResource: String? = null
)