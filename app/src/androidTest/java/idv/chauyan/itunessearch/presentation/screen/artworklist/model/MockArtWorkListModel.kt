package idv.chauyan.itunessearch.presentation.screen.artworklist.model

import idv.chauyan.itunessearch.domain.usecases.GetArtWorks
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.model.exts.toPresentationModel
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract

class MockArtWorkListModel(
  private val getArtWorks: GetArtWorks
) : ArtWorkListContract.Model {

  override suspend fun getArtWorks(keyword: String): List<PresentationArtWork> {
    return getArtWorks.get(keyword).map { it.toPresentationModel() }
  }

  override fun cacheSearchResult(keyword: String, artWorks: List<PresentationArtWork>) {
  }

  override fun getCachedResultByKey(keyword: String): List<PresentationArtWork> {
    return arrayListOf()
  }

  override fun cleanCache() {
    // do nothing
  }

}