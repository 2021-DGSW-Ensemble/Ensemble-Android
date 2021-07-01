package org.dgsw.ensemble.viewmodel

import android.content.Intent.ShortcutIconResource.fromContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.dgsw.ensemble.model.model.VideoData
import org.dgsw.ensemble.model.repository.MemoryVideoRepository
import org.dgsw.ensemble.model.repository.abstraction.VideoRepository
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val videoRepository: VideoRepository
) : ViewModel() {

    private val videoDataList: MutableList<VideoData> = ArrayList()
    private val videoDataListMutableLiveData = MutableLiveData<List<VideoData>>()
    private var page = 0L


    init {
        fetchVideoList()
    }

    private fun fetchVideoList() {
        CoroutineScope(Dispatchers.Main).launch {
            val getPage = page++
            val videoList: List<VideoData>
            withContext(Dispatchers.IO) {
                videoList = videoRepository.getVideoList(getPage * 20,20)
            }

            videoDataList.addAll(videoList)
            videoDataListMutableLiveData.value = videoDataList
        }
    }

    fun getVideoDataListMutableLiveData() : LiveData<List<VideoData>>
        = videoDataListMutableLiveData

    fun getVideoDataList(): List<VideoData> = videoDataList

}
//TODO: getItem using view model
//arraylist

