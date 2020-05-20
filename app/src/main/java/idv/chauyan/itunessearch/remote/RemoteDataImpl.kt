package idv.chauyan.itunessearch.remote

import idv.chauyan.itunessearch.data.respository.RemoteData
import idv.chauyan.itunessearch.remote.api.SearchAPI

class RemoteDataImpl(
  private val api: SearchAPI
): RemoteData {
  override suspend fun getArtWorks() = api.getArtWorks()
}