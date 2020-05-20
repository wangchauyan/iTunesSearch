package idv.chauyan.itunessearch.data

import idv.chauyan.itunessearch.data.respository.DataSource
import idv.chauyan.itunessearch.data.respository.RemoteData
import idv.chauyan.itunessearch.domain.DomainRepository

class DataRespository(
  private val dataSource: DataSource
) : DomainRepository {

  override suspend fun getArtWorks() = (dataSource as RemoteData).getArtWorks()
}