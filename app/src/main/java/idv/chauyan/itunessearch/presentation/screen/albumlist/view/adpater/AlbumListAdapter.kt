package idv.chauyan.itunessearch.presentation.screen.albumlist.view.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import idv.chauyan.itunessearch.R
import idv.chauyan.itunessearch.presentation.model.PresentationAlbum
import idv.chauyan.itunessearch.presentation.screen.albumlist.AlbumListContract
import kotlinx.android.synthetic.main.fragment_art_work_item.view.*
import kotlinx.android.synthetic.main.fragment_art_work_loadmore.view.*

class AlbumListAdapter(
  private val context: Context,
  private val albums: ArrayList<PresentationAlbum>,
  private val listener: AlbumListContract.View.AlbumListBehavior?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  enum class ItemType {
    TYPE_DISPLAY_ARTWORK
  }

  private val itemOnClickListener: View.OnClickListener

  init {
    itemOnClickListener = View.OnClickListener { v ->
      val item = v.tag as PresentationAlbum
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

  override fun getItemCount(): Int = albums.size

  override fun getItemViewType(position: Int): Int = ItemType.TYPE_DISPLAY_ARTWORK.ordinal

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (holder is ArtWorkItem) {

      holder.container.animation = AnimationUtils.loadAnimation(
        context,
        R.anim.fade_scale_animation
      )

      val item = albums[position]
      Picasso.get()
        .load(item.artWorkThumbnailSmall)
        .into(holder.artWorkLogo)
      holder.artistName.text = item.artistName
      holder.collectionName.text = item.collectionName
      holder.collectionPrice.text = "$".plus(item.collectionPrice ?: "")

      with(holder.view) {
        tag = item
        setOnClickListener(itemOnClickListener)
      }
    } else if (holder is ArtWorkLoading) {
      holder.artWorkLoading.isIndeterminate = true
    }
  }

  fun updateArtworks(
    data: List<PresentationAlbum>
  ) {
    albums.clear()
    albums.addAll(data)
    notifyDataSetChanged()
  }

  fun showLoading() {
    albums.add(
      PresentationAlbum()
    )
    notifyItemInserted(albums.size - 1)
  }

  fun dismissLoading() {
    albums.removeAt(albums.lastIndex)
    notifyItemRemoved(albums.size)
  }

  /**
   * Art work item
   */
  inner class ArtWorkItem(val view: View) : RecyclerView.ViewHolder(view) {

    val container: ViewGroup = view.container
    val artWorkLogo: ShapeableImageView = view.artWorkImage
    val artistName: TextView = view.artistName
    val collectionName: TextView = view.collectionName
    val collectionPrice: TextView = view.collectionPrice
  }

  inner class ArtWorkLoading(val view: View) : RecyclerView.ViewHolder(view) {
    val artWorkLoading: ProgressBar = view.artWorkLoading
  }
}