package idv.chauyan.itunessearch.presentation.model.exts

import idv.chauyan.itunessearch.domain.model.DomainArtWork
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork

fun DomainArtWork.toPresentationModel(): PresentationArtWork = PresentationArtWork(
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

fun PresentationArtWork.toDomainModel(): DomainArtWork = DomainArtWork(
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