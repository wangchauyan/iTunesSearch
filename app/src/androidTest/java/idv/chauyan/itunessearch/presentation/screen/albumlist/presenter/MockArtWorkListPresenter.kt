package idv.chauyan.itunessearch.presentation.screen.albumlist.presenter

import idv.chauyan.itunessearch.presentation.model.PresentationAlbum
import idv.chauyan.itunessearch.presentation.screen.albumlist.ArtWorkListContract
import kotlinx.coroutines.runBlocking

class MockArtWorkListPresenter(
  private val model: ArtWorkListContract.Model,
  private val view: ArtWorkListContract.View
) : ArtWorkListContract.Presenter {

  override fun getAlbumsByKeyword(keyword: String) {
    runBlocking {
      val data = model.getAlbumsByKeyword(keyword)
      view.updateAlbumList(data)
    }
  }

  override fun cacheSearchResult(keyword: String, albums: List<PresentationAlbum>) {
    model.cacheSearchResult(keyword, albums)
  }

  override fun getCachedResultByKey(keyword: String): List<PresentationAlbum> {
    return model.getCachedResultByKey(keyword)
  }

  override fun cleanCache() {
    model.cleanCache()
  }
}