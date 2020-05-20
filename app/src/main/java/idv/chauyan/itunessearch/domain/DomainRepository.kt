package idv.chauyan.itunessearch.domain

import idv.chauyan.itunessearch.data.DataRespository
import idv.chauyan.itunessearch.data.respository.RemoteData

interface DomainRepository {

  suspend fun getArtWorks()

  companion object {
    fun create(debug: Boolean): DomainRepository {
      return DataRespository(RemoteData.createRemoteDataSource(debug))
    }
  }
}