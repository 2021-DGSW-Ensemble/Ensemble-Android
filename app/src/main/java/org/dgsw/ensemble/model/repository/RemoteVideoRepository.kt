package org.dgsw.ensemble.model.repository

import com.google.gson.JsonElement
import com.google.gson.JsonParser
import org.dgsw.ensemble.model.datasource.remote.VideoService
import org.dgsw.ensemble.model.model.VideoData
import org.dgsw.ensemble.model.repository.abstraction.VideoRepository
import org.json.JSONArray
import org.json.JSONObject
import javax.inject.Inject


// 192.168.0.26
class RemoteVideoRepository @Inject constructor(
    private val videoService: VideoService
) : VideoRepository {

    override fun getVideoList(offset: Long, amount: Long): List<VideoData> {
        val responseBody = videoService.getVideoList(offset, amount).execute().body()
        val jsonString = responseBody!!.string()

        val jsonArray = JsonParser().parse(jsonString).asJsonArray

        val length = jsonArray.size()
        val videoDataList: MutableList<VideoData> = ArrayList(length)
        for (i in 0 until length) {
            val item = jsonArray[i].asJsonObject
            val videoData = VideoData(
                item["id"].asLong,
                item["name"].asString,
                item["url"].asString,
                safe(item["thumbnail"])?.asString ?: "",
                item["time"].asLong,
                safe(item["progress"])?.asFloat ?: 0.0f,
            )
            videoDataList.add(videoData)
        }

        return videoDataList
    }

    override fun findVideo(id: Long): VideoData? = null

    private fun safe(element: JsonElement): JsonElement? =
        if (element.isJsonNull) null else element

}