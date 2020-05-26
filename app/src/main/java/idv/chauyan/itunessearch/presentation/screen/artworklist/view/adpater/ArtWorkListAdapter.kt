package idv.chauyan.itunessearch.presentation.screen.artworklist.view.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import idv.chauyan.itunessearch.R
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract
import kotlinx.android.synthetic.main.fragment_art_work_item.view.*
import kotlinx.android.synthetic.main.fragment_art_work_loadmore.view.*

class ArtWorkListAdapter(
  private val context: Context,
  private val artWorks: ArrayList<PresentationArtWork>,
  private val listener: ArtWorkListContract.View.ArtWorkListBehavior?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  enum class ItemType {
    TYPE_DISPLAY_ARTWORK
  }

  private val itemOnClickListener: View.OnClickListener

  init {
    itemOnClickListener = View.OnClickListener { v ->
      val item = v.tag as PresentationArtWork
      listener?.onSelectedAlbum(item)
    }
  }


  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): RecyclerView.ViewHolder = when (viewType) {
    ItemType.TYPE_DISPLAY_ARTWORK.ordinal -> {
      val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.fragment_art_work_item, parent, false)
      ArtWorkItem(view)
    }
    else -> {
      val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.fragment_art_work_loadmore, parent, false)
      ArtWorkLoading(view)
    }
  }

  override fun getItemCount(): Int = artWorks.size

  override fun getItemViewType(position: Int): Int = ItemType.TYPE_DISPLAY_ARTWORK.ordinal

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (holder is ArtWorkItem) {

      holder.container.animation = AnimationUtils.loadAnimation(
        context,
        R.anim.fade_scale_animation
      )

      val item = artWorks[position]
      Picasso.get()
        .load(item.artWorkThumbnailSmall)
        .into(holder.artWorkLogo)
      holder.artistName.text = item.artistName
      holder.trackName.text = item.collectionName

      with(holder.view) {
        tag = item
        setOnClickListener(itemOnClickListener)
      }
    } else if (holder is ArtWorkLoading) {
      holder.artWorkLoading.isIndeterminate = true
    }
  }

  fun updateArtworks(
    data: List<PresentationArtWork>
  ) {
    artWorks.clear()
    artWorks.addAll(data)
    notifyDataSetChanged()
  }

  fun showLoading() {
    artWorks.add(
      PresentationArtWork()
    )
    notifyItemInserted(artWorks.size - 1)
  }

  fun dismissLoading() {
    artWorks.removeAt(artWorks.lastIndex)
    notifyItemRemoved(artWorks.size)
  }

  /**
   * Art work item
   */
  inner class ArtWorkItem(val view: View) : RecyclerView.ViewHolder(view) {

    val container: ViewGroup = view.container
    val artWorkLogo: ImageView = view.artWorkImage
    val artistName: TextView = view.artistName
    val trackName: TextView = view.collectionName
  }

  inner class ArtWorkLoading(val view: View) : RecyclerView.ViewHolder(view) {
    val artWorkLoading: ProgressBar = view.artWorkLoading
  }
}