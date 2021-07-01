package org.dgsw.ensemble.viewmodel

import android.content.Intent.ShortcutIconResource.fromContext
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    companion object {
        val TAG = MainActivityViewModel::class.simpleName
    }

    private val videoDataList: MutableList<VideoData> = ArrayList()
    private val videoDataListMutableLiveData = MutableLiveData<List<VideoData>>()
    private var page = 0L

    private var loadFirst = true


    fun fetchFirst() {
        if (loadFirst) {
            loadFirst = false
            fetchVideoList()
        }
    }

    fun fetchVideoList() {
        viewModelScope.launch {
            try {
                val videoList = withContext(Dispatchers.IO) {
                    videoRepository.getVideoList(page++ * 20,20)
                }

                videoDataList.addAll(videoList)
                videoDataListMutableLiveData.value = videoDataList
            } catch (t: Throwable) {
                Log.e(TAG, "failed to get data", t)
            }
        }
    }

    fun getVideoDataListMutableLiveData() : LiveData<List<VideoData>>
        = videoDataListMutableLiveData

    fun getVideoDataList(): List<VideoData> = videoDataList

}
//TODO: getItem using view model
//arraylist

