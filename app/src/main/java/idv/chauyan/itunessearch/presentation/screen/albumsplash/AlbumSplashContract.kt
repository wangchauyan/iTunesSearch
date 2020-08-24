package idv.chauyan.itunessearch.presentation.screen.albumsplash

import idv.chauyan.itunessearch.presentation.BasePresenter
import idv.chauyan.itunessearch.presentation.BaseView

interface AlbumSplashContract {
  interface Presenter : BasePresenter
  interface View : BaseView<Presenter>
}