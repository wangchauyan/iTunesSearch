package idv.chauyan.itunessearch.presentation.screen.artworkdetail

import idv.chauyan.itunessearch.presentation.BasePresenter
import idv.chauyan.itunessearch.presentation.BaseView
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork

interface ArtWorkDetailContract {
  interface Model {
    suspend fun getTracksByAlbumTitle(albumTitle: String): List<PresentationArtWork>
  }

  interface Presenter : BasePresenter {
    fun getTracksByAlbumTitle(
      albumTitle: String,
      collectionId: String
    )
  }

  interface View : BaseView<Presenter> {
    fun updateTrackList(tracks: List<PresentationArtWork>)
  }
}