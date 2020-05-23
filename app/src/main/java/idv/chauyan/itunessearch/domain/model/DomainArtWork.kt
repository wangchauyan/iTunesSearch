package idv.chauyan.itunessearch.domain.model

data class DomainArtWork(
  val wrapperType: String,
  val collectionType: String,
  val artistId: String?,
  val collectionId: String?,
  val amgArtistId: String?,
  val artistName: String,
  val collectionName: String,
  val artistViewUrl: String,
  val collectionViewUrl: String,
  val collectionPrice: Double,
  val trackCount: Long,
  val copyright: String,
  val country: String,
  val currency: String,
  val releaseDate: String,
  val primaryGenreName: String,
  val artWorkThumbnailSmall: String,
  val artWorkThumbnailLarge: String
)