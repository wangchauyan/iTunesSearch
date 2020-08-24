package idv.chauyan.itunessearch.presentation.model.exts

import idv.chauyan.itunessearch.domain.model.DomainAlbum
import idv.chauyan.itunessearch.presentation.model.PresentationAlbum

fun DomainAlbum.toPresentationModel(): PresentationAlbum = PresentationAlbum(
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

fun PresentationAlbum.toDomainModel(): DomainAlbum = DomainAlbum(
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