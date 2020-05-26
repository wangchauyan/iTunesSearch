package idv.chauyan.itunessearch.presentation.screen.artworkdetail.presenter

import idv.chauyan.itunessearch.presentation.screen.artworkdetail.ArtWorkDetailContract
import kotlinx.coroutines.runBlocking

class ArtWorkDetailPresenter(
  private val model: ArtWorkDetailContract.Model,
  private val view: ArtWorkDetailContract.View
) : ArtWorkDetailContract.Presenter {

  override fun getTracksByAlbumTitle(
    albumTitle: String,
    collectionId: String
  ) {
    runBlocking {
      val tracks = model
        .getTracksByAlbumTitle(albumTitle)
        .filter { it.collectionId == collectionId }
        .sortedBy { it.trackNumber }
      view.updateTrackList(tracks)
    }
  }
}