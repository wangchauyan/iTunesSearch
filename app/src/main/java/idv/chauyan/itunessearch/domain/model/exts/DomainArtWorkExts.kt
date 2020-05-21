package idv.chauyan.itunessearch.domain.model.exts

import idv.chauyan.itunessearch.data.model.DataArtWork
import idv.chauyan.itunessearch.domain.model.DomainArtWork

fun DomainArtWork.toDataModel(): DataArtWork = DataArtWork(
  trackId,
  artistId,
  collectionId,
  kind,
  wrapperType,
  artistName,
  collectionName,
  trackName,
  artWorkThumbnailSmall,
  artWorkThumbnailLarge,
  artWorkTrial,
  country,
  primaryGenreName,
  isStreamable
)

fun DataArtWork.toDomainModel(): DomainArtWork = DomainArtWork(
  trackId,
  artistId,
  collectionId,
  kind,
  wrapperType,
  artistName,
  collectionName,
  trackName,
  artWorkThumbnailSmall,
  artWorkThumbnailLarge,
  artWorkTrial,
  country,
  primaryGenreName,
  isStreamable
)