package com.codingwithmitch.motionlayoutexample


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingwithmitch.motionlayoutexample.YouTubeDemoViewHolder.*


class FrontPhotosAdapter : RecyclerView.Adapter<YouTubeDemoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YouTubeDemoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.youtube_motion_recyclerview_expanded_text_header -> TextHeaderViewHolder(
                itemView
            )
            R.layout.youtube_motion_recyclerview_expanded_text_description -> TextDescriptionViewHolder(
                itemView
            )
            R.layout.youtube_motion_expanded_row -> SceneRowViewHolder(
                itemView
            )
            else -> throw IllegalStateException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: YouTubeDemoViewHolder, position: Int) {
        when (holder) {
            is TextHeaderViewHolder -> {}
            is TextDescriptionViewHolder -> {}
            is SceneRowViewHolder -> {
                val imagePosition = position - 2
                holder.textView.text = holder.textView.resources.getString(R.string.scene_n, imagePosition)
                Glide.with(holder.imageView)
                    .load(Scenes.scenes[imagePosition])
                    .into(holder.imageView)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        return when (position) {
            0 -> R.layout.youtube_motion_recyclerview_expanded_text_header
            1 -> R.layout.youtube_motion_recyclerview_expanded_text_description
            else -> R.layout.youtube_motion_expanded_row
        }
    }

    override fun getItemCount() = Scenes.scenes.size + 2 // For text header and text description
}

sealed class YouTubeDemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class TextHeaderViewHolder(
        itemView: View
    ) : YouTubeDemoViewHolder(itemView)

    class TextDescriptionViewHolder(
        itemView: View
    ) : YouTubeDemoViewHolder(itemView)

    class SceneRowViewHolder(
        itemView: View
    ) : YouTubeDemoViewHolder(itemView) {
        val imageView = itemView.findViewById(R.id.image_row) as ImageView
        val textView = itemView.findViewById(R.id.text_row) as TextView
    }
}