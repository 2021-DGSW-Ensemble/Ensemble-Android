package org.dgsw.ensemble.model.datasource.remote

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface VideoService {

    @GET("api/v1/video_list")
    fun getVideoList(@Path("offset") offset: Long, @Path("amount") amount: Long): Call<ResponseBody>


}