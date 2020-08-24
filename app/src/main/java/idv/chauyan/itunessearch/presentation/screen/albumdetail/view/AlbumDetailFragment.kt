package idv.chauyan.itunessearch.presentation.screen.albumdetail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import idv.chauyan.itunessearch.R
import idv.chauyan.itunessearch.domain.DomainRepository
import idv.chauyan.itunessearch.domain.usecases.GetTracksByAlbumTitle
import idv.chauyan.itunessearch.presentation.model.PresentationAlbum
import idv.chauyan.itunessearch.presentation.screen.albumdetail.AlbumDetailContract
import idv.chauyan.itunessearch.presentation.screen.albumdetail.model.AlbumDetailModel
import idv.chauyan.itunessearch.presentation.screen.albumdetail.presenter.AlbumDetailPresenter
import java.lang.StringBuilder


class AlbumDetailFragment : Fragment(), AlbumDetailContract.View {

  private var args: ArtWorkDetailFragmentArgs? = null
  private lateinit var albumImage: ImageView
  private lateinit var albumTitle: TextView
  private lateinit var artistName: TextView
  private lateinit var releaseDate: TextView
  private lateinit var musicType: TextView
  private lateinit var albumPrice: TextView
  private lateinit var albumTracks: TextView

  private lateinit var presenter: AlbumDetailContract.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      args = ArtWorkDetailFragmentArgs.fromBundle(it)
    }

    val model = AlbumDetailModel(GetTracksByAlbumTitle(DomainRepository.create(false)))
    setPresenter(AlbumDetailPresenter(model, this))
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
    albumPrice = view.findViewById(R.id.album_price)
    albumTracks = view.findViewById(R.id.album_tracks)

    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // fill in related information
    args?.albumDetail?.let {
      Picasso.get().load(it.artWorkThumbnailLarge).into(albumImage)
      albumTitle.text = getString(R.string.artwork_album_title).plus(it.collectionName)
      artistName.text = getString(R.string.artwork_artist_name).plus(it.artistName)
      releaseDate.text = getString(R.string.artwork_release_date).plus(it.releaseDate)
      musicType.text = getString(R.string.artwork_music_genre).plus(it.primaryGenreName)
      albumPrice.text = getString(R.string.artwork_album_price).plus(it.collectionPrice)
    }
  }

  override fun onResume() {
    super.onResume()
    args?.albumDetail?.let {
      presenter.getTracksByAlbumTitle(it.collectionName, it.collectionId)
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    presenter.cancelAllJobs()
  }

  /**
   * ArtWorkDetailContract View interfaces
   */
  override fun setPresenter(presenter: AlbumDetailContract.Presenter) {
    this.presenter = presenter
  }

  override fun updateTrackList(tracks: List<PresentationAlbum>) {
    val stringBuilder = StringBuilder()
    tracks.forEach {
      stringBuilder.append("\n".plus(it.trackNumber).plus(": ").plus(it.trackName))
    }
    albumTracks.text = getString(R.string.artwork_album_tracks).plus(stringBuilder.toString())
  }
}