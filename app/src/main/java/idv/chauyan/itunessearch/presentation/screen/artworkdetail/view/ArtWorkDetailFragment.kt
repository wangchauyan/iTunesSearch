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
import idv.chauyan.itunessearch.domain.DomainRepository
import idv.chauyan.itunessearch.domain.usecases.GetAlbumsByKeyword
import idv.chauyan.itunessearch.domain.usecases.GetTracksByAlbumTitle
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.screen.artworkdetail.ArtWorkDetailContract
import idv.chauyan.itunessearch.presentation.screen.artworkdetail.model.ArtWorkDetailModel
import idv.chauyan.itunessearch.presentation.screen.artworkdetail.presenter.ArtWorkDetailPresenter
import idv.chauyan.itunessearch.presentation.screen.artworklist.model.ArtWorkListModel
import idv.chauyan.itunessearch.presentation.screen.artworklist.presenter.ArtWorkListPresenter


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

    val model = ArtWorkDetailModel(GetTracksByAlbumTitle(DomainRepository.create(false)))
    setPresenter(ArtWorkDetailPresenter(model, this))
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

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // fill in related information
    args?.ArtWorkDetail?.let {
      Picasso.get().load(it.artWorkThumbnailLarge).into(albumImage)
      albumTitle.text = it.collectionName
      artistName.text = it.artistName
      releaseDate.text = it.releaseDate
      musicType.text = it.primaryGenreName
    }
  }

  override fun onResume() {
    super.onResume()
    args?.ArtWorkDetail?.let {
      presenter.getTracksByAlbumTitle(it.collectionName, it.collectionId)
    }
  }

  /**
   * ArtWorkDetailContract View interfaces
   */
  override fun setPresenter(presenter: ArtWorkDetailContract.Presenter) {
    this.presenter = presenter
  }

  override fun updateTrackList(tracks: List<PresentationArtWork>) {
    tracks.forEach {
      println("track name : ".plus(it.trackName))
    }
  }
}