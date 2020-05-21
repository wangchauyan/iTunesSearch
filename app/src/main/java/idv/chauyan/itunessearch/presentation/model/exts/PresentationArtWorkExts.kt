package idv.chauyan.itunessearch.presentation.model.exts

import idv.chauyan.itunessearch.domain.model.DomainArtWork
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork

fun DomainArtWork.toPresentationModel(): PresentationArtWork = PresentationArtWork(
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

fun PresentationArtWork.toDomainModel(): DomainArtWork = DomainArtWork(
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