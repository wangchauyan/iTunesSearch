package idv.chauyan.itunessearch.remote

import idv.chauyan.itunessearch.data.model.exts.toDataModel
import idv.chauyan.itunessearch.data.respository.RemoteData
import idv.chauyan.itunessearch.remote.api.SearchAPI

class RemoteDataImpl(
  private val api: SearchAPI
) : RemoteData {

  override suspend fun getAlbumsByKeyword(keyword: String) = api.getArtWorks(
    mapOf(
      "term" to keyword,
      "entity" to "album"
    )
  ).results.map { it.toDataModel() }

  override suspend fun getTracksByAlbumTitle(albumTitle: String) = api.getArtWorks(
    mapOf(
      "term" to albumTitle,
      "entity" to "song",
      "attribute" to "albumTerm",
      "limit" to "10000"
    )
  ).results.map { it.toDataModel() }
}