package idv.chauyan.itunessearch.data.model.exts

import idv.chauyan.itunessearch.data.model.DataArtWork
import idv.chauyan.itunessearch.remote.model.ArtWork

fun DataArtWork.toRemoteModel(): ArtWork = ArtWork(
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

fun ArtWork.toDataModel(): DataArtWork = DataArtWork(
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