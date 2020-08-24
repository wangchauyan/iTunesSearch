package idv.chauyan.itunessearch.data.model

data class DataAlbum(
  val wrapperType: String,
  val artistId: String?,
  val collectionId: String,
  val artistName: String,
  val collectionName: String,
  val artistViewUrl: String,
  val collectionViewUrl: String,
  val collectionPrice: Double?,
  val trackCount: Long,
  val country: String,
  val currency: String,
  val releaseDate: String,
  val primaryGenreName: String,

  // track information
  val trackName: String?,
  val trackNumber: Int?,
  val trackPrice: Double?,

  val artWorkThumbnailSmall: String,
  val artWorkThumbnailLarge: String
)