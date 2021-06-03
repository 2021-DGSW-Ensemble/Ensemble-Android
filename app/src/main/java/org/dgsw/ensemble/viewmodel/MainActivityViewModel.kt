package org.dgsw.ensemble.viewmodel

import SingleLiveEvent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.dgsw.ensemble.model.model.VideoData
import org.dgsw.ensemble.model.repository.MemoryVideoRepository
import org.dgsw.ensemble.model.repository.abstraction.VideoRepository

class MainActivityViewModel(private val videoRepository: VideoRepository) : ViewModel() {


    private val videoDataArrayListMutableLiveData = MutableLiveData<ArrayList<VideoData>>()
    private var page = 0L


    init {
        videoRepository.getVideoList((page++) * 20,20)
    }



    fun onButtonClick() {

    }

    fun getVideoList(): List<VideoData> =
            videoRepository.getVideoList((page++) * 20,20)

    fun getVideoDataArrayListLiveData() : LiveData<ArrayList<VideoData>>
    = videoDataArrayListMutableLiveData


}
//TODO: getItem using view model
//arraylist

