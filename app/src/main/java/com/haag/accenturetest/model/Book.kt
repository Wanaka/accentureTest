package com.haag.accenturetest.model

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("name") var title: String,
    @SerializedName("isbn") var isbn: String,
    @SerializedName("authors") val authors: List<String>,
    @SerializedName("numberOfPages") val numberOfPages: Long,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("country") val country: String,
    @SerializedName("mediaType") val mediaType: String,
    @SerializedName("released") val released: String
)