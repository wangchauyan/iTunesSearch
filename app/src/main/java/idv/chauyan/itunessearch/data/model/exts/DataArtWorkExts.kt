package idv.chauyan.itunessearch.data.model.exts

import idv.chauyan.itunessearch.data.model.DataArtWork
import idv.chauyan.itunessearch.remote.model.ArtWork

fun DataArtWork.toRemoteModel(): ArtWork = ArtWork(
  trackId,
  artistId,
  collectionId,
  kind,
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

fun ArtWork.toDataModel(): DataArtWork = DataArtWork(
  trackId,
  artistId,
  collectionId,
  kind,
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