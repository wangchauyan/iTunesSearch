package idv.chauyan.itunessearch.presentation.screen.artworklist.presenter

import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract
import kotlinx.coroutines.runBlocking

class ArtWorkListPresenter(
  private val model: ArtWorkListContract.Model,
  private val view: ArtWorkListContract.View
) : ArtWorkListContract.Presenter {

  override fun getArtWorks(keyword: String) {
    runBlocking {
      val artWorks = model.getArtWorks(keyword)
      view.updateArtWorkList(artWorks)
    }
  }

  override fun cacheSearchResult(
    keyword: String,
    artWorks: List<PresentationArtWork>
  ) {
    model.cacheSearchResult(keyword, artWorks)
  }

  override fun cleanCache() {
    model.cleanCache()
  }
}