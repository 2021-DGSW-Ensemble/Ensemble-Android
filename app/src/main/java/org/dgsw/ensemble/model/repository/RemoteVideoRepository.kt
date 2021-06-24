package org.dgsw.ensemble.model.repository

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

        val jsonArray = JSONArray(jsonString)

        val length = jsonArray.length()
        val videoDataList: MutableList<VideoData> = ArrayList(length)
        for (i in 0 until length) {
            val item = jsonArray[i] as JSONObject
            val videoData = VideoData(
                item["id"] as Long,
                item["name"] as String,
                item["path"] as String,
                item["thumbnail"] as String?,
                item["time"] as Long,
                item["progress"] as Float,
            )
            videoDataList.add(videoData)
        }

        return videoDataList
    }

    override fun findVideo(id: Long): VideoData? = null


}