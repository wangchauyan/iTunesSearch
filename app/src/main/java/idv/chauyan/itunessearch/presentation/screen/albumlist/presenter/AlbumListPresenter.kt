package idv.chauyan.itunessearch.presentation.screen.albumlist.presenter

import idv.chauyan.itunessearch.presentation.model.PresentationAlbum
import idv.chauyan.itunessearch.presentation.screen.albumlist.AlbumListContract
import kotlinx.coroutines.runBlocking

class AlbumListPresenter(
  private val model: AlbumListContract.Model,
  private val view: AlbumListContract.View
) : AlbumListContract.Presenter {

  override fun getAlbumsByKeyword(keyword: String) {
    runBlocking {
      val artWorks = model.getAlbumsByKeyword(keyword)
      view.updateAlbumList(artWorks)
    }
  }

  override fun cacheSearchResult(
    keyword: String,
    albums: List<PresentationAlbum>
  ) {
    model.cacheSearchResult(keyword, albums)
  }

  override fun getCachedResultByKey(keyword: String): List<PresentationAlbum> {
    return model.getCachedResultByKey(keyword)
  }

  override fun cleanCache() {
    model.cleanCache()
  }
}