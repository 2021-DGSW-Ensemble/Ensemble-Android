package org.dgsw.ensemble.model.repository.abstract

import android.provider.MediaStore
import org.dgsw.ensemble.model.model.VideoData

interface VideoRepository {

    fun getVideoList(offset: Long, amount: Long): List<VideoData>

    fun findVideo(id: Long): VideoData?

}