package idv.chauyan.itunessearch.domain.model.exts

import idv.chauyan.itunessearch.data.model.DataArtWork
import idv.chauyan.itunessearch.domain.model.DomainArtWork

fun DomainArtWork.toDataModel(): DataArtWork = DataArtWork(
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

fun DataArtWork.toDomainModel(): DomainArtWork = DomainArtWork(
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