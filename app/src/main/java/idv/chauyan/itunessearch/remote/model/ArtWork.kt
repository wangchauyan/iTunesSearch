package idv.chauyan.itunessearch.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtWork(
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