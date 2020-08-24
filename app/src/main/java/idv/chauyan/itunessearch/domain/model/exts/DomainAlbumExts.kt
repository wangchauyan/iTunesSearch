package idv.chauyan.itunessearch.domain.model.exts

import idv.chauyan.itunessearch.data.model.DataAlbum
import idv.chauyan.itunessearch.domain.model.DomainAlbum

fun DomainAlbum.toDataModel(): DataAlbum = DataAlbum(
  wrapperType,
  artistId,
  collectionId,
  artistName,
  collectionName,
  artistViewUrl,
  collectionViewUrl,
  collectionPrice,
  trackCount,
  country,
  currency,
  releaseDate,
  primaryGenreName,
  trackName,
  trackNumber,
  trackPrice,
  artWorkThumbnailSmall,
  artWorkThumbnailLarge
)

fun DataAlbum.toDomainModel(): DomainAlbum = DomainAlbum(
  wrapperType,
  artistId,
  collectionId,
  artistName,
  collectionName,
  artistViewUrl,
  collectionViewUrl,
  collectionPrice,
  trackCount,
  country,
  currency,
  releaseDate,
  primaryGenreName,
  trackName,
  trackNumber,
  trackPrice,
  artWorkThumbnailSmall,
  artWorkThumbnailLarge
)