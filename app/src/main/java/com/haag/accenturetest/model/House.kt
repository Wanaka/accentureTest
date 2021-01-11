package com.haag.accenturetest.model

import com.google.gson.annotations.SerializedName

data class House(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("region") var region: String,
    @SerializedName("title") var title: String
)