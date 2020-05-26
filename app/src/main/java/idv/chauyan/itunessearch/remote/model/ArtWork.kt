package idv.chauyan.itunessearch.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtWork(
  // album information
  val wrapperType: String,
  val artistId: String?,
  val collectionId: String,
  val artistName: String,
  val collectionName: String,
  val artistViewUrl: String,
  val collectionViewUrl: String,
  val collectionPrice: Double,
  val trackCount: Long,
  val country: String,
  val currency: String,
  val releaseDate: String,
  val primaryGenreName: String,

  // track information
  val trackName: String?,
  val trackNumber: Int?,
  val trackPrice: Double?,

  @Json(name = "artworkUrl60")
  val artWorkThumbnailSmall: String,

  @Json(name = "artworkUrl100")
  val artWorkThumbnailLarge: String
)

@JsonClass(generateAdapter = true)
data class ArtWorks(
  val resultCount: Int,
  val results: List<ArtWork>
)