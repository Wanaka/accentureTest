package com.haag.accenturetest.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "categories_table")
data class Categories(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "category")
    @SerializedName("category_name") var categories: String,
    @ColumnInfo(name = "type")
    @SerializedName("type") var type: Int
) : Parcelable