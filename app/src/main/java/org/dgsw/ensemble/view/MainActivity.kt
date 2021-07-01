package org.dgsw.ensemble.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import org.dgsw.ensemble.R
import org.dgsw.ensemble.view.custom.RecyclerItemClickListener
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
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addOnItemTouchListener(RecyclerItemClickListener(this, object: RecyclerItemClickListener.OnItemClickListener.Normal {
            override fun onItemClick(view: View, position: Int) {
                val model = viewModel.getVideoDataList()[position];
                val intent = Intent(this@MainActivity, VideoActivity::class.java).apply {
                    putExtra("url", model.path)
                }
                startActivity(intent)
            }

            override fun onItemLongClick(view: View, position: Int) {
                onItemClick(view, position)
            }
        }))

        viewModel.getVideoDataListMutableLiveData().observe(this, {
            videoAdapter.notifyDataSetChanged()
            // TODO : apply diffutil in this mechanism.
        })
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchFirst()
    }



}