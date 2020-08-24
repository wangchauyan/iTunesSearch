package idv.chauyan.itunessearch.presentation.screen.albumlist

import idv.chauyan.itunessearch.presentation.BasePresenter
import idv.chauyan.itunessearch.presentation.BaseView
import idv.chauyan.itunessearch.presentation.model.PresentationAlbum

interface AlbumListContract {

  interface Model {
    suspend fun getAlbumsByKeyword(keyword: String): List<PresentationAlbum>
    fun cacheSearchResult(
      keyword: String,
      albums: List<PresentationAlbum>
    )

    fun getCachedResultByKey(keyword: String): List<PresentationAlbum>

    fun cleanCache()
  }

  interface Presenter : BasePresenter {
    fun getAlbumsByKeyword(keyword: String)
    fun cacheSearchResult(
      keyword: String,
      albums: List<PresentationAlbum>
    )

    fun getCachedResultByKey(keyword: String): List<PresentationAlbum>

    fun cleanCache()
  }

  interface View : BaseView<Presenter> {
    fun updateAlbumList(albums: List<PresentationAlbum>)

    interface AlbumListBehavior {
      fun onSelectedAlbum(album: PresentationAlbum)
    }
  }
}