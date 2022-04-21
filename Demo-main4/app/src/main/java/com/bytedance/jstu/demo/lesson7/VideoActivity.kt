package com.bytedance.jstu.demo.lesson7

import android.graphics.PixelFormat
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.jstu.demo.R

class VideoActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private lateinit var buttonPlay: Button
    private lateinit var buttonPause: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_video)

        videoView = findViewById(R.id.videoView)
        buttonPause = findViewById(R.id.buttonPause)
        buttonPlay = findViewById(R.id.buttonPlay)

        buttonPause.setOnClickListener { videoView.pause() }
        buttonPlay.setOnClickListener { videoView.start() }
        videoView.holder.setFormat(PixelFormat.TRANSPARENT)
        //把SurfaceView置于Activity显示窗口的最顶层
        videoView.setZOrderOnTop(true)

        //设置资源路径 即可自动播放
        videoView.setVideoPath(getVideoPath(R.raw.big_buck_bunny))
    }

    //资源id转化成path
    private fun getVideoPath(resId: Int): String {
        return "android.resource://" + this.packageName + "/" + resId
    }
}