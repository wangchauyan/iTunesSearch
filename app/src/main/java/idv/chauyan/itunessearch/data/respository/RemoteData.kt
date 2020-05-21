package idv.chauyan.itunessearch.data.respository

import idv.chauyan.itunessearch.data.model.DataArtWork
import idv.chauyan.itunessearch.remote.RemoteDataImpl
import idv.chauyan.itunessearch.remote.api.SearchAPI

interface RemoteData : DataSource {
  suspend fun getArtWorks(): List<DataArtWork>

  companion object {
    fun createRemoteDataSource(debug: Boolean): RemoteData {
      return RemoteDataImpl(SearchAPI.create(debug))
    }
  }
}