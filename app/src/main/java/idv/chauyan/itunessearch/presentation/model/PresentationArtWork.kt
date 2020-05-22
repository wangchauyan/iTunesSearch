package idv.chauyan.itunessearch.presentation.model

data class PresentationArtWork(
  val trackId: String? = null,
  val artistId: String? = null,
  val collectionId: String? = null,
  val kind: String? = null,
  val wrapperType: String = "",
  val artistName: String = "",
  val collectionName: String? = null,
  val trackName: String? = null,
  val artWorkThumbnailSmall: String = "",
  val artWorkThumbnailLarge: String = "",
  val artWorkTrial: String = "",
  val country: String = "",
  val primaryGenreName: String = "",
  val isStreamable: Boolean? = false
)