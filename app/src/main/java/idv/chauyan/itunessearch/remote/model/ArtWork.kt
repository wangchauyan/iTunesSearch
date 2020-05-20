package idv.chauyan.itunessearch.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtWork(
  val trackId: String,
  val artistId: String,
  val collectionId: String,
  val kind: String,
  val artistName: String,
  val collectionName: String,
  val trackName: String,
  @Json(name = "artworkUrl30")
  val artWorkThumbnailSmall: String,
  @Json(name = "artworkUrl100")
  val artWorkThumbnailLarge: String,
  @Json(name = "previewUrl")
  val artWorkTrial: String,
  val country: String,
  val primaryGenreName: String,
  val isStreamable: Boolean
)