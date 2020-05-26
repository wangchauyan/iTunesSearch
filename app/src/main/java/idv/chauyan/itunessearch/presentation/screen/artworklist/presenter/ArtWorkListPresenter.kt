package idv.chauyan.itunessearch.presentation.screen.artworklist.presenter

import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract
import kotlinx.coroutines.runBlocking

class ArtWorkListPresenter(
  private val model: ArtWorkListContract.Model,
  private val view: ArtWorkListContract.View
) : ArtWorkListContract.Presenter {

  override fun getAlbumsByKeyword(keyword: String) {
    runBlocking {
      val artWorks = model.getAlbumsByKeyword(keyword)
      view.updateAlbumList(artWorks)
    }
  }

  override fun cacheSearchResult(
    keyword: String,
    artWorks: List<PresentationArtWork>
  ) {
    model.cacheSearchResult(keyword, artWorks)
  }

  override fun getCachedResultByKey(keyword: String): List<PresentationArtWork> {
    return model.getCachedResultByKey(keyword)
  }

  override fun cleanCache() {
    model.cleanCache()
  }
}