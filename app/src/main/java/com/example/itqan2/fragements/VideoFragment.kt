package com.example.itqan2.fragements

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import com.example.itqan2.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VideoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VideoFragment : Fragment() {
    private var videoUrl: String? = null
    private lateinit var videoView: VideoView

    companion object {
        fun newInstance(url: String) = VideoFragment().apply {
            arguments = Bundle().apply { putString("video_url", url) }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_video, container, false)
        videoView = view.findViewById(R.id.videoView)
        videoUrl = arguments?.getString("video_url")

        videoUrl?.let {
            val uri = Uri.parse(it)
            videoView.setVideoURI(uri)
            videoView.setOnPreparedListener { mediaPlayer -> mediaPlayer.start() }
        }

        return view
    }
}
