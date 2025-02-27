package com.example.itqan2.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.itqan2.FullScreenImageDialog
import com.example.itqan2.R
import com.example.itqan2.models.MediaType
import com.example.itqan2.models.Post
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

class PostAdapter(
    private val posts: List<Post>,
    private val listener: OnPostClickListener
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private val activePlayers = mutableSetOf<ExoPlayer>()

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postTitle: TextView = view.findViewById(R.id.postTitle)
        val postDescription: TextView = view.findViewById(R.id.postText)
        val postImage: ImageView = view.findViewById(R.id.postImage)
        val playerView: PlayerView = view.findViewById(R.id.playerView)
        val audioPlayerView: PlayerView = view.findViewById(R.id.audioPlayerView)
        val mediaContainer: FrameLayout = view.findViewById(R.id.mediaContainer)
        var player: ExoPlayer? = null
        var audioPlayer: ExoPlayer? = null

        init {
            itemView.setOnClickListener { listener.onPostClick(posts[adapterPosition]) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]

        // Clear previous media
        clearMedia(holder)

        // Set basic content
        holder.postTitle.text = post.title
        holder.postDescription.text = post.description

        // Handle media content
        when (post.mediaType) {
            MediaType.IMAGE -> showImage(holder, post)
            MediaType.VIDEO -> showVideo(holder, post)
            MediaType.AUDIO -> showAudio(holder, post)
            else -> hideAllMediaViews(holder)
        }
    }

    override fun getItemCount() = posts.size

    override fun onViewRecycled(holder: PostViewHolder) {
        super.onViewRecycled(holder)
        clearMedia(holder)
    }

    private fun showImage(holder: PostViewHolder, post: Post) {
        holder.postImage.visibility = View.VISIBLE
        Glide.with(holder.itemView.context)
            .load(post.mediaUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_image)
            .into(holder.postImage)

        holder.postImage.setOnClickListener {
            FullScreenImageDialog(holder.itemView.context, post.mediaUrl).show()
        }
    }

    private fun showVideo(holder: PostViewHolder, post: Post) {
        holder.playerView.visibility = View.VISIBLE

        val player = ExoPlayer.Builder(holder.itemView.context).build().apply {
            setMediaItem(MediaItem.fromUri(post.mediaUrl))
            prepare()
            playWhenReady = true // تشغيل الفيديو تلقائيًا
        }

        holder.player = player
        holder.playerView.player = player
        holder.playerView.useController = true // تفعيل عناصر التحكم
        activePlayers.add(player)
    }


    private fun showAudio(holder: PostViewHolder, post: Post) {
        holder.audioPlayerView.visibility = View.VISIBLE
        val audioPlayer = ExoPlayer.Builder(holder.itemView.context).build().apply {
            setMediaItem(MediaItem.fromUri(post.mediaUrl))
            prepare()
        }
        holder.audioPlayer = audioPlayer
        holder.audioPlayerView.player = audioPlayer
        activePlayers.add(audioPlayer)
    }

    private fun clearMedia(holder: PostViewHolder) {
        holder.postImage.visibility = View.GONE
        holder.playerView.visibility = View.INVISIBLE // تغيير GONE إلى INVISIBLE
        holder.audioPlayerView.visibility = View.INVISIBLE

        holder.player?.let {
            activePlayers.remove(it)
            it.release()
        }
        holder.audioPlayer?.let {
            activePlayers.remove(it)
            it.release()
        }
        holder.player = null
        holder.audioPlayer = null
    }


    private fun hideAllMediaViews(holder: PostViewHolder) {
        holder.postImage.visibility = View.GONE
        holder.playerView.visibility = View.GONE
        holder.audioPlayerView.visibility = View.GONE
    }

    fun releaseAllPlayers() {
        activePlayers.forEach { it.release() }
        activePlayers.clear()
    }

    interface OnPostClickListener {
        fun onPostClick(post: Post)
    }
}