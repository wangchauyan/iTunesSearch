package idv.chauyan.itunessearch.presentation.screen.artworklist.model

import android.util.LruCache
import idv.chauyan.itunessearch.domain.usecases.GetAlbumsByKeyword
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.model.exts.toPresentationModel
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract

class ArtWorkListModel(
  private val getAlbumsByKeyword: GetAlbumsByKeyword
) : ArtWorkListContract.Model {

  private val cacheSize = 4 * 1024 * 1024
  private val searchCache = LruCache<String, List<PresentationArtWork>>(cacheSize)

  override suspend fun getArtWorks(keyword: String): List<PresentationArtWork> =
    getAlbumsByKeyword.get(keyword).map { it.toPresentationModel() }

  override fun cacheSearchResult(
    keyword: String,
    artWorks: List<PresentationArtWork>
  ) {
    searchCache.put(keyword, artWorks)
  }

  override fun getCachedResultByKey(keyword: String): List<PresentationArtWork> {
    return searchCache.get(keyword)
  }

  override fun cleanCache() {
    searchCache.evictAll()
  }
}