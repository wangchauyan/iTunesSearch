package idv.chauyan.itunessearch.presentation.screen.artworklist.model

import idv.chauyan.itunessearch.domain.usecases.GetArtWorks
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.model.exts.toPresentationModel
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract

class ArtWorkListModel(
  private val getArtWorks: GetArtWorks
) : ArtWorkListContract.Model {

  override suspend fun getArtWorks(): List<PresentationArtWork> =
    getArtWorks.get().map { it.toPresentationModel() }
}