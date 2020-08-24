package idv.chauyan.itunessearch.presentation.screen.albumdetail.model

import idv.chauyan.itunessearch.domain.usecases.GetTracksByAlbumTitle
import idv.chauyan.itunessearch.presentation.model.exts.toPresentationModel
import idv.chauyan.itunessearch.presentation.screen.albumdetail.AlbumDetailContract

class AlbumDetailModel(
  private val getTracksByAlbumTitle: GetTracksByAlbumTitle
) : AlbumDetailContract.Model {

  override suspend fun getTracksByAlbumTitle(albumTitle: String) =
    getTracksByAlbumTitle.get(albumTitle).map { it.toPresentationModel() }
}