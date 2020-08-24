package idv.chauyan.itunessearch.presentation.screen.albumlist.model

import android.util.LruCache
import idv.chauyan.itunessearch.domain.usecases.GetAlbumsByKeyword
import idv.chauyan.itunessearch.presentation.model.PresentationAlbum
import idv.chauyan.itunessearch.presentation.model.exts.toPresentationModel
import idv.chauyan.itunessearch.presentation.screen.albumlist.AlbumListContract

class AlbumListModel(
  private val getAlbumsByKeyword: GetAlbumsByKeyword
) : AlbumListContract.Model {

  private val cacheSize = 4 * 1024 * 1024
  private val searchCache = LruCache<String, List<PresentationAlbum>>(cacheSize)

  override suspend fun getAlbumsByKeyword(keyword: String): List<PresentationAlbum> =
    getAlbumsByKeyword.get(keyword).map { it.toPresentationModel() }

  override fun cacheSearchResult(
    keyword: String,
    albums: List<PresentationAlbum>
  ) {
    searchCache.put(keyword, albums)
  }

  override fun getCachedResultByKey(keyword: String): List<PresentationAlbum> {
    return searchCache.get(keyword)
  }

  override fun cleanCache() {
    searchCache.evictAll()
  }
}