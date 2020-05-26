package idv.chauyan.itunessearch.domain.usecases

import idv.chauyan.itunessearch.domain.DomainRepository

class GetTracksByAlbumTitle(
  private val domainRepository: DomainRepository
) {

  suspend fun get(albumTitle: String) = domainRepository.getTracksByAlbumTitle(albumTitle)
}