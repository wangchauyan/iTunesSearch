package idv.chauyan.itunessearch.presentation.screen.artworklist.model

import idv.chauyan.itunessearch.domain.usecases.GetAlbumsByKeyword
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.model.exts.toPresentationModel
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract

class MockArtWorkListModel(
  private val getAlbumsByKeyword: GetAlbumsByKeyword
) : ArtWorkListContract.Model {

  override suspend fun getArtWorks(keyword: String): List<PresentationArtWork> {
    return getAlbumsByKeyword.get(keyword).map { it.toPresentationModel() }
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