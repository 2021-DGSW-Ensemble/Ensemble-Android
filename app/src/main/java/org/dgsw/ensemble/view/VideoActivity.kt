package org.dgsw.ensemble.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import org.dgsw.ensemble.R

class VideoActivity : AppCompatActivity() {

    private val DEFAULT_URL = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) 
        setContentView(R.layout.activity_video)

        val url = intent.getStringExtra("url") ?: DEFAULT_URL

        //val VideoUrl = "http://192.168.0.26:8080/video/2-testtest.mp4"

        val mVv = findViewById<VideoView>(R.id.videoView)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnResume = findViewById<Button>(R.id.btnResume)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnStop = findViewById<Button>(R.id.btnStop)

//        val uri:Uri = Uri.parse(VIDEO_PATH)
        mVv.setVideoURI(Uri.parse(url))
        mVv.setMediaController(MediaController(this))
        mVv.requestFocus()

        mVv.setOnPreparedListener{
            Toast.makeText(applicationContext,"동영상 재생 준비 완료", Toast.LENGTH_SHORT).show()
            mVv.start()
        }

        mVv.setOnCompletionListener {
            Toast.makeText(applicationContext,"동영상 시청 완료", Toast.LENGTH_SHORT).show()
        }

        btnStart.setOnClickListener{
            mVv.start()
        }

        btnResume.setOnClickListener{
            mVv.resume()
        }

        btnPause.setOnClickListener {
            mVv.pause()
        }

        btnStop.setOnClickListener{
            mVv.pause()
            mVv.stopPlayback()
        }
    }

}