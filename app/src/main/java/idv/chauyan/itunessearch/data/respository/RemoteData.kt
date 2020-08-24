package idv.chauyan.itunessearch.data.respository

import idv.chauyan.itunessearch.data.model.DataAlbum
import idv.chauyan.itunessearch.remote.RemoteDataImpl
import idv.chauyan.itunessearch.remote.api.SearchAPI

interface RemoteData : DataSource {
  suspend fun getAlbumsByKeyword(keyword: String): List<DataAlbum>
  suspend fun getTracksByAlbumTitle(albumTitle: String): List<DataAlbum>

  companion object {
    fun createRemoteDataSource(debug: Boolean): RemoteData {
      return RemoteDataImpl(SearchAPI.create(debug))
    }
  }
}