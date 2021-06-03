package org.dgsw.ensemble.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import org.dgsw.ensemble.R
import org.dgsw.ensemble.viewmodel.MainActivityViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val videoAdapter = VideoAdapter(viewModel.getVideoDataList())
        val recyclerView = findViewById<RecyclerView>(R.id.main_list)
        recyclerView.adapter = videoAdapter

        viewModel.getVideoDataListMutableLiveData().observe(this, {
            videoAdapter.notifyDataSetChanged()
            // TODO : apply diffutil in this mechanism.
        })

    }

}