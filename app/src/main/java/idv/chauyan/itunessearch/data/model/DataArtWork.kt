package idv.chauyan.itunessearch.data.model

data class DataArtWork(
  val trackId: String?,
  val artistId: String?,
  val collectionId: String?,
  val kind: String?,
  val wrapperType: String,
  val artistName: String,
  val collectionName: String?,
  val trackName: String?,
  val artWorkThumbnailSmall: String,
  val artWorkThumbnailLarge: String,
  val artWorkTrial: String?,
  val country: String,
  val primaryGenreName: String,
  val isStreamable: Boolean?
)