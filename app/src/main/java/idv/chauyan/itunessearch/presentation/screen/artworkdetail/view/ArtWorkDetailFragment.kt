package idv.chauyan.itunessearch.presentation.screen.artworkdetail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import idv.chauyan.itunessearch.R
import idv.chauyan.itunessearch.presentation.screen.artworkdetail.ArtWorkDetailContract


class ArtWorkDetailFragment : Fragment(), ArtWorkDetailContract.View {

  private var args: ArtWorkDetailFragmentArgs? = null
  private lateinit var albumImage: ImageView
  private lateinit var albumTitle: TextView
  private lateinit var artistName: TextView
  private lateinit var releaseDate: TextView
  private lateinit var musicType: TextView

  private lateinit var presenter: ArtWorkDetailContract.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      args = ArtWorkDetailFragmentArgs.fromBundle(it)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_art_work_detail, container, false)
    albumImage = view.findViewById(R.id.album_image)
    albumTitle = view.findViewById(R.id.album_title)
    artistName = view.findViewById(R.id.artist_name)
    releaseDate = view.findViewById(R.id.release_date)
    musicType = view.findViewById(R.id.music_type)

    return view
  }

  override fun onResume() {
    super.onResume()

    args?.ArtWorkDetail?.artWorkThumbnailLarge?.let {
      Picasso.get().load(it).into(albumImage)
    }

  }

  /**
   * ArtWorkDetailContract View interfaces
   */
  override fun setPresenter(presenter: ArtWorkDetailContract.Presenter) {
    this.presenter = presenter
  }
}