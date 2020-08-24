package idv.chauyan.itunessearch.domain

import idv.chauyan.itunessearch.data.DataRepository
import idv.chauyan.itunessearch.data.respository.RemoteData
import idv.chauyan.itunessearch.domain.model.DomainAlbum

interface DomainRepository {

  suspend fun getAlbumsByKeyword(keyword: String): List<DomainAlbum>
  suspend fun getTracksByAlbumTitle(albumTitle: String): List<DomainAlbum>

  companion object {
    fun create(debug: Boolean): DomainRepository {
      return DataRepository(RemoteData.createRemoteDataSource(debug))
    }
  }
}