package idv.chauyan.itunessearch.domain.model.exts

import idv.chauyan.itunessearch.data.model.DataArtWork
import idv.chauyan.itunessearch.domain.model.DomainArtWork

fun DomainArtWork.toDataModel(): DataArtWork = DataArtWork(
  wrapperType,
  collectionType,
  artistId,
  collectionId,
  amgArtistId,
  artistName,
  collectionName,
  artistViewUrl,
  collectionViewUrl,
  collectionPrice,
  trackCount,
  copyright,
  country,
  currency,
  releaseDate,
  primaryGenreName,
  artWorkThumbnailSmall,
  artWorkThumbnailLarge
)

fun DataArtWork.toDomainModel(): DomainArtWork = DomainArtWork(
  wrapperType,
  collectionType,
  artistId,
  collectionId,
  amgArtistId,
  artistName,
  collectionName,
  artistViewUrl,
  collectionViewUrl,
  collectionPrice,
  trackCount,
  copyright,
  country,
  currency,
  releaseDate,
  primaryGenreName,
  artWorkThumbnailSmall,
  artWorkThumbnailLarge
)