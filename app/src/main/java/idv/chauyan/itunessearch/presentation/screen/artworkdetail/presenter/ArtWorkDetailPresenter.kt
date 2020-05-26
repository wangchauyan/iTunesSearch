package idv.chauyan.itunessearch.presentation.screen.artworkdetail.presenter

import idv.chauyan.itunessearch.presentation.screen.artworkdetail.ArtWorkDetailContract
import kotlinx.coroutines.*

class ArtWorkDetailPresenter(
  private val model: ArtWorkDetailContract.Model,
  private val view: ArtWorkDetailContract.View
) : ArtWorkDetailContract.Presenter {

  private var job: Job? = null

  override fun getTracksByAlbumTitle(
    albumTitle: String,
    collectionId: String
  ) {
    job = GlobalScope.launch {
      val tracks = model
        .getTracksByAlbumTitle(albumTitle)
        .filter { it.collectionId == collectionId }
        .sortedBy { it.trackNumber }

      withContext(Dispatchers.Main) {
        view.updateTrackList(tracks)
      }
    }
  }

  override fun cancelAllJobs() {
    job?.apply { cancel() }
  }
}