package idv.chauyan.itunessearch.domain.model.exts

import com.google.common.truth.Truth.assertThat
import idv.chauyan.itunessearch.data.model.DataAlbum
import idv.chauyan.itunessearch.domain.model.DomainAlbum
import org.junit.After
import org.junit.Before
import org.junit.Test

class DomainAlbumExtsKtTest {

  private var srcDataAlbum: DataAlbum? = null
  private var destDataAlbum: DataAlbum? = null

  private var srcDomainAlbum: DomainAlbum? = null
  private var destDomainAlbum: DomainAlbum? = null

  @Before
  fun setUp() {
    // initialize `data`, `domain` layer artworks
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

    srcDomainAlbum = DomainAlbum(
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
    srcDataAlbum = null
    destDataAlbum = null

    srcDomainAlbum = null
    destDomainAlbum = null
  }

  @Test
  fun toDataModel() {
    destDataAlbum = srcDomainAlbum?.toDataModel()
    assertThat(destDataAlbum).isNotNull()
    assertThat(destDataAlbum?.wrapperType).isEqualTo(srcDomainAlbum?.wrapperType)
    assertThat(destDataAlbum?.artistId).isEqualTo(srcDomainAlbum?.artistId)
    assertThat(destDataAlbum?.collectionId).isEqualTo(srcDomainAlbum?.collectionId)
    assertThat(destDataAlbum?.artistName).isEqualTo(srcDomainAlbum?.artistName)
    assertThat(destDataAlbum?.collectionName).isEqualTo(srcDomainAlbum?.collectionName)
    assertThat(destDataAlbum?.artistViewUrl).isEqualTo(srcDomainAlbum?.artistViewUrl)
    assertThat(destDataAlbum?.collectionViewUrl).isEqualTo(srcDomainAlbum?.collectionViewUrl)
    assertThat(destDataAlbum?.collectionPrice).isEqualTo(srcDomainAlbum?.collectionPrice)
    assertThat(destDataAlbum?.trackCount).isEqualTo(srcDomainAlbum?.trackCount)
    assertThat(destDataAlbum?.country).isEqualTo(srcDomainAlbum?.country)
    assertThat(destDataAlbum?.currency).isEqualTo(srcDomainAlbum?.currency)
    assertThat(destDataAlbum?.releaseDate).isEqualTo(srcDomainAlbum?.releaseDate)
    assertThat(destDataAlbum?.primaryGenreName).isEqualTo(srcDomainAlbum?.primaryGenreName)
    assertThat(destDataAlbum?.artWorkThumbnailSmall).isEqualTo(
      srcDomainAlbum?.artWorkThumbnailSmall)
    assertThat(destDataAlbum?.artWorkThumbnailLarge).isEqualTo(
      srcDomainAlbum?.artWorkThumbnailLarge)
  }

  @Test
  fun toDomainModel() {
    destDomainAlbum = srcDataAlbum?.toDomainModel()
    assertThat(destDomainAlbum).isNotNull()
    assertThat(destDomainAlbum?.wrapperType).isEqualTo(srcDataAlbum?.wrapperType)
    assertThat(destDomainAlbum?.artistId).isEqualTo(srcDataAlbum?.artistId)
    assertThat(destDomainAlbum?.collectionId).isEqualTo(srcDataAlbum?.collectionId)
    assertThat(destDomainAlbum?.artistName).isEqualTo(srcDataAlbum?.artistName)
    assertThat(destDomainAlbum?.collectionName).isEqualTo(srcDataAlbum?.collectionName)
    assertThat(destDomainAlbum?.artistViewUrl).isEqualTo(srcDataAlbum?.artistViewUrl)
    assertThat(destDomainAlbum?.collectionViewUrl).isEqualTo(srcDataAlbum?.collectionViewUrl)
    assertThat(destDomainAlbum?.collectionPrice).isEqualTo(srcDataAlbum?.collectionPrice)
    assertThat(destDomainAlbum?.trackCount).isEqualTo(srcDataAlbum?.trackCount)
    assertThat(destDomainAlbum?.country).isEqualTo(srcDataAlbum?.country)
    assertThat(destDomainAlbum?.currency).isEqualTo(srcDataAlbum?.currency)
    assertThat(destDomainAlbum?.releaseDate).isEqualTo(srcDataAlbum?.releaseDate)
    assertThat(destDomainAlbum?.primaryGenreName).isEqualTo(srcDataAlbum?.primaryGenreName)
    assertThat(destDomainAlbum?.artWorkThumbnailSmall).isEqualTo(
      srcDataAlbum?.artWorkThumbnailSmall)
    assertThat(destDomainAlbum?.artWorkThumbnailLarge).isEqualTo(
      srcDataAlbum?.artWorkThumbnailLarge)
  }
}