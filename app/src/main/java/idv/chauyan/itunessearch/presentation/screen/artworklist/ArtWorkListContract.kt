package idv.chauyan.itunessearch.presentation.screen.artworklist

import idv.chauyan.itunessearch.presentation.BasePresenter
import idv.chauyan.itunessearch.presentation.BaseView

interface ArtWorkListContract {

  interface Model {
    suspend fun getArtWorks()
  }

  interface Presenter : BasePresenter {
    fun getArtWorks()
  }

  interface View : BaseView<Presenter> {
    fun updateArtWorkList()

    interface ArtWorkListBehavior {
      fun onSelectedArtWork()
    }
  }
}