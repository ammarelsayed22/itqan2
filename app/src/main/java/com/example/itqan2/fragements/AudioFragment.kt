package com.example.itqan2.fragements

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.itqan2.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AudioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AudioFragment : Fragment() {
    private var audioUrl: String? = null
    private var mediaPlayer: MediaPlayer? = null

    companion object {
        fun newInstance(url: String) = AudioFragment().apply {
            arguments = Bundle().apply { putString("audio_url", url) }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_audio, container, false)
        val playButton: Button = view.findViewById(R.id.playButton)
        audioUrl = arguments?.getString("audio_url")

        playButton.setOnClickListener {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer().apply {
                    setDataSource(audioUrl)
                    prepare()
                    start()
                }
            } else {
                mediaPlayer?.start()
            }
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}

