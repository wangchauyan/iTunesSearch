package idv.chauyan.itunessearch.presentation.screen.albumdetail.presenter

import idv.chauyan.itunessearch.presentation.screen.albumdetail.AlbumDetailContract
import kotlinx.coroutines.*

class AlbumDetailPresenter(
  private val model: AlbumDetailContract.Model,
  private val view: AlbumDetailContract.View
) : AlbumDetailContract.Presenter {

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