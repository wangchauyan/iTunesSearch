package idv.chauyan.itunessearch.domain

import idv.chauyan.itunessearch.data.DataRepository
import idv.chauyan.itunessearch.data.respository.RemoteData
import idv.chauyan.itunessearch.domain.model.DomainArtWork

interface DomainRepository {

  suspend fun getArtWorks(keyword: String): List<DomainArtWork>

  companion object {
    fun create(debug: Boolean): DomainRepository {
      return DataRepository(RemoteData.createRemoteDataSource(debug))
    }
  }
}