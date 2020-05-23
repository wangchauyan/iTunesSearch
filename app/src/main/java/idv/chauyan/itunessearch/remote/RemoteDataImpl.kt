package idv.chauyan.itunessearch.remote

import idv.chauyan.itunessearch.data.model.exts.toDataModel
import idv.chauyan.itunessearch.data.respository.RemoteData
import idv.chauyan.itunessearch.remote.api.SearchAPI

class RemoteDataImpl(
  private val api: SearchAPI
) : RemoteData {

  override suspend fun getArtWorks() = api.getArtWorks(
    mapOf(
      "term" to "Swift",
      "entity" to "album"
    )
  ).results.map { it.toDataModel() }
}