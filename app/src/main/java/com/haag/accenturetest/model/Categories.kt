package com.haag.accenturetest.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Categories(
    @SerializedName("category_name") var categories: String,
    @SerializedName("type") var type: Int
): Parcelable