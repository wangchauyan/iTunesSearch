package idv.chauyan.itunessearch.presentation.screen.artworkdetail.model

import idv.chauyan.itunessearch.domain.usecases.GetTracksByAlbumTitle
import idv.chauyan.itunessearch.presentation.model.exts.toPresentationModel
import idv.chauyan.itunessearch.presentation.screen.artworkdetail.ArtWorkDetailContract

class ArtWorkDetailModel(
  private val getTracksByAlbumTitle: GetTracksByAlbumTitle
) : ArtWorkDetailContract.Model {

  override suspend fun getTracksByAlbumTitle(albumTitle: String) =
    getTracksByAlbumTitle.get(albumTitle).map { it.toPresentationModel() }
}