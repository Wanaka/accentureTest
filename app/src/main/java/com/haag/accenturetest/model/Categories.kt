package com.haag.accenturetest.model

import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("category_name") var categories: String,
    @SerializedName("type") var type: Int
)