package idv.chauyan.itunessearch.data.model.exts

import com.google.common.truth.Truth.assertThat
import idv.chauyan.itunessearch.data.model.DataArtWork
import idv.chauyan.itunessearch.remote.model.ArtWork
import org.junit.After
import org.junit.Before
import org.junit.Test

class DataArtWorkExtsKtTest {

  private var srcRemoteArtWork: ArtWork? = null
  private var destRemoteArtWork: ArtWork? = null

  private var srcDataArtWork: DataArtWork? = null
  private var destDataArtWork: DataArtWork? = null

  @Before
  fun setUp() {
    // initialize `remote`, `data` layer artworks
    srcRemoteArtWork = ArtWork(
      "collection",
      "Album",
      "159260351",
      "1440935467",
      "816977",
      "Taylor Swift",
      "1989",
      "https://music.apple.com/us/artist/taylor-swift/159260351?uo=4",
      "https://music.apple.com/us/album/1989/1440935467?uo=4",
      10.99,
      14,
      "℗ 2014 Big Machine Records, LLC.",
      "USA",
      "USD",
      "2014-10-27T07:00:00Z",
      "Pop",
      "https://is5-ssl.mzstatic.com/image/thumb/Music128/v4/9c/91/83/9c918303-e0a4-2d4b-97d6-f986b9fba604/source/60x60bb.jpg",
      "https://is5-ssl.mzstatic.com/image/thumb/Music128/v4/9c/91/83/9c918303-e0a4-2d4b-97d6-f986b9fba604/source/100x100bb.jpg"
    )

    srcDataArtWork = DataArtWork(
      "collection",
      "Album",
      "159260351",
      "1440935467",
      "816977",
      "Taylor Swift",
      "1989",
      "https://music.apple.com/us/artist/taylor-swift/159260351?uo=4",
      "https://music.apple.com/us/album/1989/1440935467?uo=4",
      10.99,
      14,
      "℗ 2014 Big Machine Records, LLC.",
      "USA",
      "USD",
      "2014-10-27T07:00:00Z",
      "Pop",
      "https://is5-ssl.mzstatic.com/image/thumb/Music128/v4/9c/91/83/9c918303-e0a4-2d4b-97d6-f986b9fba604/source/60x60bb.jpg",
      "https://is5-ssl.mzstatic.com/image/thumb/Music128/v4/9c/91/83/9c918303-e0a4-2d4b-97d6-f986b9fba604/source/100x100bb.jpg"
    )
  }

  @After
  fun tearDown() {
    srcRemoteArtWork = null
    destRemoteArtWork = null

    srcDataArtWork = null
    destDataArtWork = null
  }

  @Test
  fun toRemoteModel() {
    destRemoteArtWork = srcDataArtWork?.toRemoteModel()
    assertThat(destRemoteArtWork).isNotNull()
    assertThat(destRemoteArtWork?.wrapperType).isEqualTo(srcDataArtWork?.wrapperType)
    assertThat(destRemoteArtWork?.collectionType).isEqualTo(srcDataArtWork?.collectionType)
    assertThat(destRemoteArtWork?.artistId).isEqualTo(srcDataArtWork?.artistId)
    assertThat(destRemoteArtWork?.collectionId).isEqualTo(srcDataArtWork?.collectionId)
    assertThat(destRemoteArtWork?.amgArtistId).isEqualTo(srcDataArtWork?.amgArtistId)
    assertThat(destRemoteArtWork?.artistName).isEqualTo(srcDataArtWork?.artistName)
    assertThat(destRemoteArtWork?.collectionName).isEqualTo(srcDataArtWork?.collectionName)
    assertThat(destRemoteArtWork?.artistViewUrl).isEqualTo(srcDataArtWork?.artistViewUrl)
    assertThat(destRemoteArtWork?.collectionViewUrl).isEqualTo(srcDataArtWork?.collectionViewUrl)
    assertThat(destRemoteArtWork?.collectionPrice).isEqualTo(srcDataArtWork?.collectionPrice)
    assertThat(destRemoteArtWork?.trackCount).isEqualTo(srcDataArtWork?.trackCount)
    assertThat(destRemoteArtWork?.copyright).isEqualTo(srcDataArtWork?.copyright)
    assertThat(destRemoteArtWork?.country).isEqualTo(srcDataArtWork?.country)
    assertThat(destRemoteArtWork?.currency).isEqualTo(srcDataArtWork?.currency)
    assertThat(destRemoteArtWork?.releaseDate).isEqualTo(srcDataArtWork?.releaseDate)
    assertThat(destRemoteArtWork?.primaryGenreName).isEqualTo(srcDataArtWork?.primaryGenreName)
    assertThat(destRemoteArtWork?.artWorkThumbnailSmall).isEqualTo(
      srcDataArtWork?.artWorkThumbnailSmall)
    assertThat(destRemoteArtWork?.artWorkThumbnailLarge).isEqualTo(
      srcDataArtWork?.artWorkThumbnailLarge)
  }

  @Test
  fun toDataModel() {
    destDataArtWork = srcRemoteArtWork?.toDataModel()
    assertThat(destDataArtWork).isNotNull()
    assertThat(destDataArtWork?.wrapperType).isEqualTo(srcRemoteArtWork?.wrapperType)
    assertThat(destDataArtWork?.collectionType).isEqualTo(srcRemoteArtWork?.collectionType)
    assertThat(destDataArtWork?.artistId).isEqualTo(srcRemoteArtWork?.artistId)
    assertThat(destDataArtWork?.collectionId).isEqualTo(srcRemoteArtWork?.collectionId)
    assertThat(destDataArtWork?.amgArtistId).isEqualTo(srcRemoteArtWork?.amgArtistId)
    assertThat(destDataArtWork?.artistName).isEqualTo(srcRemoteArtWork?.artistName)
    assertThat(destDataArtWork?.collectionName).isEqualTo(srcRemoteArtWork?.collectionName)
    assertThat(destDataArtWork?.artistViewUrl).isEqualTo(srcRemoteArtWork?.artistViewUrl)
    assertThat(destDataArtWork?.collectionViewUrl).isEqualTo(srcRemoteArtWork?.collectionViewUrl)
    assertThat(destDataArtWork?.collectionPrice).isEqualTo(srcRemoteArtWork?.collectionPrice)
    assertThat(destDataArtWork?.trackCount).isEqualTo(srcRemoteArtWork?.trackCount)
    assertThat(destDataArtWork?.copyright).isEqualTo(srcRemoteArtWork?.copyright)
    assertThat(destDataArtWork?.country).isEqualTo(srcRemoteArtWork?.country)
    assertThat(destDataArtWork?.currency).isEqualTo(srcRemoteArtWork?.currency)
    assertThat(destDataArtWork?.releaseDate).isEqualTo(srcRemoteArtWork?.releaseDate)
    assertThat(destDataArtWork?.primaryGenreName).isEqualTo(srcRemoteArtWork?.primaryGenreName)
    assertThat(destDataArtWork?.artWorkThumbnailSmall).isEqualTo(
      srcRemoteArtWork?.artWorkThumbnailSmall)
    assertThat(destDataArtWork?.artWorkThumbnailLarge).isEqualTo(
      srcRemoteArtWork?.artWorkThumbnailLarge)
  }
}