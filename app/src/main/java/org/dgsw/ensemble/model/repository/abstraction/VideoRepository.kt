package org.dgsw.ensemble.model.repository.abstraction

import org.dgsw.ensemble.model.model.VideoData

interface VideoRepository {

    fun getVideoList(offset: Long, amount: Long): List<VideoData>

    fun findVideo(id: Long): VideoData?

}