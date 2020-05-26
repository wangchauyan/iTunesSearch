package idv.chauyan.itunessearch.data

import idv.chauyan.itunessearch.data.respository.DataSource
import idv.chauyan.itunessearch.data.respository.RemoteData
import idv.chauyan.itunessearch.domain.DomainRepository
import idv.chauyan.itunessearch.domain.model.exts.toDomainModel

class DataRepository(
  private val dataSource: DataSource
) : DomainRepository {

  override suspend fun getAlbumsByKeyword(keyword: String) =
    (dataSource as RemoteData).getAlbumsByKeyword(keyword).map { it.toDomainModel() }

  override suspend fun getTracksByAlbumTitle(albumTitle: String) =
    (dataSource as RemoteData).getTracksByAlbumTitle(albumTitle).map { it.toDomainModel() }
}