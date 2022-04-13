package com.example.testapplication.model

import com.google.gson.annotations.SerializedName

data class QuoteList(
    @SerializedName("count")
    val count2: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)
