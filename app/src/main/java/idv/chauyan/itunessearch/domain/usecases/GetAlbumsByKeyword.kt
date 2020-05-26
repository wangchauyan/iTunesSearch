package idv.chauyan.itunessearch.domain.usecases

import idv.chauyan.itunessearch.domain.DomainRepository

class GetAlbumsByKeyword(
  private val domainRepository: DomainRepository
) {

  suspend fun get(keyword: String) = domainRepository.getAlbumsByKeyword(keyword)
}