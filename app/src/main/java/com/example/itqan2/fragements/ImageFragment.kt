package com.example.itqan2.fragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.itqan2.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImageFragment : Fragment() {

    private var imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageUrl = arguments?.getString("imageUrl")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_image, container, false)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.placeholder) // صورة بديلة أثناء التحميل
            .error(R.drawable.error_image) // صورة بديلة في حالة الخطأ
            .into(imageView)

        return view
    }

    companion object {
        fun newInstance(imageUrl: String) = ImageFragment().apply {
            arguments = Bundle().apply {
                putString("imageUrl", imageUrl)
            }
        }
    }
}
