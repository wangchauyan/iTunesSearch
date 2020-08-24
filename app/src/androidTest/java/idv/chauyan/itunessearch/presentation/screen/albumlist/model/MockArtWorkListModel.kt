package idv.chauyan.itunessearch.presentation.screen.albumlist.model

import idv.chauyan.itunessearch.domain.usecases.GetAlbumsByKeyword
import idv.chauyan.itunessearch.presentation.model.PresentationAlbum
import idv.chauyan.itunessearch.presentation.model.exts.toPresentationModel
import idv.chauyan.itunessearch.presentation.screen.albumlist.ArtWorkListContract

class MockArtWorkListModel(
  private val getAlbumsByKeyword: GetAlbumsByKeyword
) : ArtWorkListContract.Model {

  override suspend fun getAlbumsByKeyword(keyword: String): List<PresentationAlbum> {
    return getAlbumsByKeyword.get(keyword).map { it.toPresentationModel() }
  }

  override fun cacheSearchResult(keyword: String, albums: List<PresentationAlbum>) {
  }

  override fun getCachedResultByKey(keyword: String): List<PresentationAlbum> {
    return arrayListOf()
  }

  override fun cleanCache() {
    // do nothing
  }

}