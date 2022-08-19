package com.example.umc_hackathon.post.result

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: DetailResult
)

data class DetailResult(
    @SerializedName("format") val format: Int,
    @SerializedName("question") val question: String,
    @SerializedName("getResultStatisticsRes") val res: List<Result>,
    @SerializedName("case1") val case1: Double,
    @SerializedName("case2") val case2: Double,
    @SerializedName("case3") val case3: Double,
    @SerializedName("case4") val case4: Double,
    @SerializedName("case5") val case5: Double,
    @SerializedName("case6") val case6: Double,
    @SerializedName("case7") val case7: Double,
    @SerializedName("case8") val case8: Double
)

data class Result(
    @SerializedName("result") val res: Int
)