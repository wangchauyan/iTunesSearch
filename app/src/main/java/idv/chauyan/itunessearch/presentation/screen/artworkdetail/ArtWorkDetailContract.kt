package idv.chauyan.itunessearch.presentation.screen.artworkdetail

import idv.chauyan.itunessearch.presentation.BasePresenter
import idv.chauyan.itunessearch.presentation.BaseView

interface ArtWorkDetailContract {
  interface Model
  interface Presenter : BasePresenter
  interface View : BaseView<Presenter> {
    
  }
}