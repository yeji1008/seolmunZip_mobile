package com.example.umc_hackathon.post

import com.google.gson.annotations.SerializedName

data class PostDetailResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result:PostDetailResult
)

data class PostDetailResult (
    @SerializedName("postUserId") val postId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("deadline") val deadline: Int,
    @SerializedName("myPost") val myPost: Boolean,
    @SerializedName("like") val like: Boolean,
    @SerializedName("qCount") val qCount: Int
)
