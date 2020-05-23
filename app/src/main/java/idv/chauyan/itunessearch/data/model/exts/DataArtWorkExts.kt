package idv.chauyan.itunessearch.data.model.exts

import idv.chauyan.itunessearch.data.model.DataArtWork
import idv.chauyan.itunessearch.remote.model.ArtWork

fun DataArtWork.toRemoteModel(): ArtWork = ArtWork(
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

fun ArtWork.toDataModel(): DataArtWork = DataArtWork(
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