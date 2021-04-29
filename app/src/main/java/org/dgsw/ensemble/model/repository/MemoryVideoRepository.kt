package org.dgsw.ensemble.model.repository

import org.dgsw.ensemble.model.model.VideoData
import org.dgsw.ensemble.model.repository.abstract.VideoRepository

class MemoryVideoRepository : VideoRepository {

    private val videoList: ArrayList<VideoData> = ArrayList()

    init {
        videoList.add(VideoData(1, "test", "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/1200px-Image_created_with_a_mobile_phone.png", 0.0f))
    }

    override fun getVideoList(offset: Long, amount: Long): List<VideoData> {
        return videoList.subList(offset.toInt(), amount.toInt())
    }

    override fun findVideo(id: Long): VideoData? {
        for (videoData in videoList) {
            if (id == videoData.id) return videoData
        }
        return null
    }


}