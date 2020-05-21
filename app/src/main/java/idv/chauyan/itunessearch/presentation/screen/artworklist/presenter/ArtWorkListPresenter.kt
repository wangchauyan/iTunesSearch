package idv.chauyan.itunessearch.presentation.screen.artworklist.presenter

import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract
import kotlinx.coroutines.runBlocking

class ArtWorkListPresenter(
  private val model: ArtWorkListContract.Model,
  private val view: ArtWorkListContract.View
) : ArtWorkListContract.Presenter {

  override fun getArtWorks() {
    runBlocking {
      val artWorks = model.getArtWorks()
      view.updateArtWorkList(artWorks)
    }
  }
}