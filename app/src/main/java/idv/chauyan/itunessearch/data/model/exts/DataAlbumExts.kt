package idv.chauyan.itunessearch.data.model.exts

import idv.chauyan.itunessearch.data.model.DataAlbum
import idv.chauyan.itunessearch.remote.model.Album

fun DataAlbum.toRemoteModel(): Album = Album(
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

fun Album.toDataModel(): DataAlbum = DataAlbum(
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