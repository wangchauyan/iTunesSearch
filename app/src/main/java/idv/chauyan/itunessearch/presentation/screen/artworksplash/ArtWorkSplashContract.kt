package idv.chauyan.itunessearch.presentation.screen.artworksplash

import idv.chauyan.itunessearch.presentation.BasePresenter
import idv.chauyan.itunessearch.presentation.BaseView

interface ArtWorkSplashContract {
  interface Presenter : BasePresenter
  interface View : BaseView<Presenter>
}