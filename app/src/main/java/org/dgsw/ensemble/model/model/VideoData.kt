package org.dgsw.ensemble.model.model

data class VideoData(
    val id: Long,
    val name: String,
    val path: String,
    val thumbnail: String?,
    val time: Long,
    val progress: Float
)
