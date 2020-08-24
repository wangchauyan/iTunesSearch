package idv.chauyan.itunessearch.data.model.exts

import com.google.common.truth.Truth.assertThat
import idv.chauyan.itunessearch.data.model.DataAlbum
import idv.chauyan.itunessearch.remote.model.Album
import org.junit.After
import org.junit.Before
import org.junit.Test

class DataAlbumExtsKtTest {

  private var srcRemoteAlbum: Album? = null
  private var destRemoteAlbum: Album? = null

  private var srcDataAlbum: DataAlbum? = null
  private var destDataAlbum: DataAlbum? = null

  @Before
  fun setUp() {
    // initialize `remote`, `data` layer artworks
    srcRemoteAlbum = Album(
      "collection",
      "159260351",
      "1440935467",
      "Taylor Swift",
      "1989",
      "https://music.apple.com/us/artist/taylor-swift/159260351?uo=4",
      "https://music.apple.com/us/album/1989/1440935467?uo=4",
      10.99,
      14,
      "USA",
      "USD",
      "2014-10-27T07:00:00Z",
      "Pop",
      "",
      0,
      0.0,
      "https://is5-ssl.mzstatic.com/image/thumb/Music128/v4/9c/91/83/9c918303-e0a4-2d4b-97d6-f986b9fba604/source/60x60bb.jpg",
      "https://is5-ssl.mzstatic.com/image/thumb/Music128/v4/9c/91/83/9c918303-e0a4-2d4b-97d6-f986b9fba604/source/100x100bb.jpg"
    )

    srcDataAlbum = DataAlbum(
      "collection",
      "159260351",
      "1440935467",
      "Taylor Swift",
      "1989",
      "https://music.apple.com/us/artist/taylor-swift/159260351?uo=4",
      "https://music.apple.com/us/album/1989/1440935467?uo=4",
      10.99,
      14,
      "USA",
      "USD",
      "2014-10-27T07:00:00Z",
      "Pop",
      "",
      0,
      0.0,
      "https://is5-ssl.mzstatic.com/image/thumb/Music128/v4/9c/91/83/9c918303-e0a4-2d4b-97d6-f986b9fba604/source/60x60bb.jpg",
      "https://is5-ssl.mzstatic.com/image/thumb/Music128/v4/9c/91/83/9c918303-e0a4-2d4b-97d6-f986b9fba604/source/100x100bb.jpg"
    )
  }

  @After
  fun tearDown() {
    srcRemoteAlbum = null
    destRemoteAlbum = null

    srcDataAlbum = null
    destDataAlbum = null
  }

  @Test
  fun toRemoteModel() {
    destRemoteAlbum = srcDataAlbum?.toRemoteModel()
    assertThat(destRemoteAlbum).isNotNull()
    assertThat(destRemoteAlbum?.wrapperType).isEqualTo(srcDataAlbum?.wrapperType)
    assertThat(destRemoteAlbum?.artistId).isEqualTo(srcDataAlbum?.artistId)
    assertThat(destRemoteAlbum?.collectionId).isEqualTo(srcDataAlbum?.collectionId)
    assertThat(destRemoteAlbum?.artistName).isEqualTo(srcDataAlbum?.artistName)
    assertThat(destRemoteAlbum?.collectionName).isEqualTo(srcDataAlbum?.collectionName)
    assertThat(destRemoteAlbum?.artistViewUrl).isEqualTo(srcDataAlbum?.artistViewUrl)
    assertThat(destRemoteAlbum?.collectionViewUrl).isEqualTo(srcDataAlbum?.collectionViewUrl)
    assertThat(destRemoteAlbum?.collectionPrice).isEqualTo(srcDataAlbum?.collectionPrice)
    assertThat(destRemoteAlbum?.trackCount).isEqualTo(srcDataAlbum?.trackCount)
    assertThat(destRemoteAlbum?.country).isEqualTo(srcDataAlbum?.country)
    assertThat(destRemoteAlbum?.currency).isEqualTo(srcDataAlbum?.currency)
    assertThat(destRemoteAlbum?.releaseDate).isEqualTo(srcDataAlbum?.releaseDate)
    assertThat(destRemoteAlbum?.primaryGenreName).isEqualTo(srcDataAlbum?.primaryGenreName)
    assertThat(destRemoteAlbum?.artWorkThumbnailSmall).isEqualTo(
      srcDataAlbum?.artWorkThumbnailSmall)
    assertThat(destRemoteAlbum?.artWorkThumbnailLarge).isEqualTo(
      srcDataAlbum?.artWorkThumbnailLarge)
  }

  @Test
  fun toDataModel() {
    destDataAlbum = srcRemoteAlbum?.toDataModel()
    assertThat(destDataAlbum).isNotNull()
    assertThat(destDataAlbum?.wrapperType).isEqualTo(srcRemoteAlbum?.wrapperType)
    assertThat(destDataAlbum?.artistId).isEqualTo(srcRemoteAlbum?.artistId)
    assertThat(destDataAlbum?.collectionId).isEqualTo(srcRemoteAlbum?.collectionId)
    assertThat(destDataAlbum?.artistName).isEqualTo(srcRemoteAlbum?.artistName)
    assertThat(destDataAlbum?.collectionName).isEqualTo(srcRemoteAlbum?.collectionName)
    assertThat(destDataAlbum?.artistViewUrl).isEqualTo(srcRemoteAlbum?.artistViewUrl)
    assertThat(destDataAlbum?.collectionViewUrl).isEqualTo(srcRemoteAlbum?.collectionViewUrl)
    assertThat(destDataAlbum?.collectionPrice).isEqualTo(srcRemoteAlbum?.collectionPrice)
    assertThat(destDataAlbum?.trackCount).isEqualTo(srcRemoteAlbum?.trackCount)
    assertThat(destDataAlbum?.country).isEqualTo(srcRemoteAlbum?.country)
    assertThat(destDataAlbum?.currency).isEqualTo(srcRemoteAlbum?.currency)
    assertThat(destDataAlbum?.releaseDate).isEqualTo(srcRemoteAlbum?.releaseDate)
    assertThat(destDataAlbum?.primaryGenreName).isEqualTo(srcRemoteAlbum?.primaryGenreName)
    assertThat(destDataAlbum?.artWorkThumbnailSmall).isEqualTo(
      srcRemoteAlbum?.artWorkThumbnailSmall)
    assertThat(destDataAlbum?.artWorkThumbnailLarge).isEqualTo(
      srcRemoteAlbum?.artWorkThumbnailLarge)
  }
}