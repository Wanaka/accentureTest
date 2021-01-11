package com.haag.accenturetest.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("gender") var gender: String,
    @SerializedName("culture") var culture: String,
    @SerializedName("born") var born: String,
    @SerializedName("died") var died: String,
    @SerializedName("titles") var titles: List<Any?>,
    @SerializedName("aliases") var aliases: List<String>,
    @SerializedName("father") var father: String,
    @SerializedName("mother") var mother: String,
    @SerializedName("spouse") var spouse: String,
    @SerializedName("allegiances") var allegiances: List<String>,
    @SerializedName("playedBy") var playedBy: List<String>
)