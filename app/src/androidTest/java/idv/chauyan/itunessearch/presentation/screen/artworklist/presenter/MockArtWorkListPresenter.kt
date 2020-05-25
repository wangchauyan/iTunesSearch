package idv.chauyan.itunessearch.presentation.screen.artworklist.presenter

import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract
import kotlinx.coroutines.runBlocking

class MockArtWorkListPresenter(
  private val model: ArtWorkListContract.Model,
  private val view: ArtWorkListContract.View
) : ArtWorkListContract.Presenter {

  override fun getArtWorks(keyword: String) {
    runBlocking {
      val data = model.getArtWorks(keyword)
      view.updateArtWorkList(data)
    }
  }

  override fun cacheSearchResult(keyword: String, artWorks: List<PresentationArtWork>) {
    model.cacheSearchResult(keyword, artWorks)
  }

  override fun getCachedResultByKey(keyword: String): List<PresentationArtWork> {
    return model.getCachedResultByKey(keyword)
  }

  override fun cleanCache() {
    model.cleanCache()
  }
}