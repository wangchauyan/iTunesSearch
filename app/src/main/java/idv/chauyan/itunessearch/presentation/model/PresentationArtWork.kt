package idv.chauyan.itunessearch.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PresentationArtWork(
  val wrapperType: String = "",
  val collectionType: String = "",
  val artistId: String? = null,
  val collectionId: String? = null,
  val amgArtistId: String? = null,
  val artistName: String = "",
  val collectionName: String = "",
  val artistViewUrl: String = "",
  val collectionViewUrl: String = "",
  val collectionPrice: Double = 0.0,
  val trackCount: Long = 0,
  val copyright: String = "",
  val country: String = "",
  val currency: String = "",
  val releaseDate: String = "",
  val primaryGenreName: String = "",
  val artWorkThumbnailSmall: String = "",
  val artWorkThumbnailLarge: String = ""
) : Parcelable