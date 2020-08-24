package idv.chauyan.itunessearch.presentation.screen.albumdetail

import idv.chauyan.itunessearch.presentation.BasePresenter
import idv.chauyan.itunessearch.presentation.BaseView
import idv.chauyan.itunessearch.presentation.model.PresentationAlbum

interface AlbumDetailContract {
  interface Model {
    suspend fun getTracksByAlbumTitle(albumTitle: String): List<PresentationAlbum>
  }

  interface Presenter : BasePresenter {
    fun getTracksByAlbumTitle(
      albumTitle: String,
      collectionId: String
    )

    fun cancelAllJobs()
  }

  interface View : BaseView<Presenter> {
    fun updateTrackList(tracks: List<PresentationAlbum>)
  }
}