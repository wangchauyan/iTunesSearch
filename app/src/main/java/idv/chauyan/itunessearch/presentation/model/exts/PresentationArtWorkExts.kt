package idv.chauyan.itunessearch.presentation.model.exts

import idv.chauyan.itunessearch.domain.model.DomainArtWork
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork

fun DomainArtWork.toPresentationModel(): PresentationArtWork = PresentationArtWork(
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

fun PresentationArtWork.toDomainModel(): DomainArtWork = DomainArtWork(
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