package idv.chauyan.itunessearch.presentation.screen.artworklist.model

import android.util.LruCache
import idv.chauyan.itunessearch.domain.usecases.GetArtWorks
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.model.exts.toPresentationModel
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract

class ArtWorkListModel(
  private val getArtWorks: GetArtWorks
) : ArtWorkListContract.Model {

  private val cacheSize = 4 * 1024 * 1024
  private val searchCache = LruCache<String, List<PresentationArtWork>>(cacheSize)

  override suspend fun getArtWorks(): List<PresentationArtWork> =
    getArtWorks.get().map { it.toPresentationModel() }

  override fun cacheSearchResult(
    keyword: String,
    artWorks: List<PresentationArtWork>
  ) {
    searchCache.put(keyword, artWorks)
  }

  override fun cleanCache() {
    searchCache.evictAll()
  }
}