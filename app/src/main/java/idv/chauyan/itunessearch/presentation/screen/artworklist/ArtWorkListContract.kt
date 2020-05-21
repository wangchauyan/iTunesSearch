package idv.chauyan.itunessearch.presentation.screen.artworklist

import idv.chauyan.itunessearch.presentation.BasePresenter
import idv.chauyan.itunessearch.presentation.BaseView
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork

interface ArtWorkListContract {

  interface Model {
    suspend fun getArtWorks(): List<PresentationArtWork>
  }

  interface Presenter : BasePresenter {
    fun getArtWorks()
  }

  interface View : BaseView<Presenter> {
    fun updateArtWorkList(artworks: List<PresentationArtWork>)

    interface ArtWorkListBehavior {
      fun onSelectedArtWork(artWork: PresentationArtWork)
    }
  }
}