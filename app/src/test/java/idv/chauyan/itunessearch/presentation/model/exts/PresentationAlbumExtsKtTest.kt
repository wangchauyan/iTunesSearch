package idv.chauyan.itunessearch.presentation.model.exts

import com.google.common.truth.Truth.assertThat
import idv.chauyan.itunessearch.domain.model.DomainAlbum
import idv.chauyan.itunessearch.presentation.model.PresentationAlbum
import org.junit.After
import org.junit.Before
import org.junit.Test

class PresentationAlbumExtsKtTest {

  private var srcPresentationAlbum: PresentationAlbum? = null
  private var destPresentationAlbum: PresentationAlbum? = null

  private var srcDomainAlbum: DomainAlbum? = null
  private var destDomainAlbum: DomainAlbum? = null

  @Before
  fun setUp() {
    // initialize `data`, `domain` layer artworks
    srcPresentationAlbum = PresentationAlbum(
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
    srcPresentationAlbum = null
    destPresentationAlbum = null

    srcDomainAlbum = null
    destDomainAlbum = null
  }

  @Test
  fun toDataModel() {
    destPresentationAlbum = srcDomainAlbum?.toPresentationModel()
    assertThat(destPresentationAlbum).isNotNull()
    assertThat(destPresentationAlbum?.wrapperType).isEqualTo(srcDomainAlbum?.wrapperType)
    assertThat(destPresentationAlbum?.artistId).isEqualTo(srcDomainAlbum?.artistId)
    assertThat(destPresentationAlbum?.collectionId).isEqualTo(srcDomainAlbum?.collectionId)
    assertThat(destPresentationAlbum?.artistName).isEqualTo(srcDomainAlbum?.artistName)
    assertThat(destPresentationAlbum?.collectionName).isEqualTo(srcDomainAlbum?.collectionName)
    assertThat(destPresentationAlbum?.artistViewUrl).isEqualTo(srcDomainAlbum?.artistViewUrl)
    assertThat(destPresentationAlbum?.collectionViewUrl).isEqualTo(
      srcDomainAlbum?.collectionViewUrl)
    assertThat(destPresentationAlbum?.collectionPrice).isEqualTo(
      srcDomainAlbum?.collectionPrice)
    assertThat(destPresentationAlbum?.trackCount).isEqualTo(srcDomainAlbum?.trackCount)
    assertThat(destPresentationAlbum?.country).isEqualTo(srcDomainAlbum?.country)
    assertThat(destPresentationAlbum?.currency).isEqualTo(srcDomainAlbum?.currency)
    assertThat(destPresentationAlbum?.releaseDate).isEqualTo(srcDomainAlbum?.releaseDate)
    assertThat(destPresentationAlbum?.primaryGenreName).isEqualTo(
      srcDomainAlbum?.primaryGenreName)
    assertThat(destPresentationAlbum?.artWorkThumbnailSmall).isEqualTo(
      srcDomainAlbum?.artWorkThumbnailSmall)
    assertThat(destPresentationAlbum?.artWorkThumbnailLarge).isEqualTo(
      srcDomainAlbum?.artWorkThumbnailLarge)
  }

  @Test
  fun toDomainModel() {
    destDomainAlbum = srcPresentationAlbum?.toDomainModel()
    assertThat(destDomainAlbum).isNotNull()
    assertThat(destDomainAlbum?.wrapperType).isEqualTo(srcPresentationAlbum?.wrapperType)
    assertThat(destDomainAlbum?.artistId).isEqualTo(srcPresentationAlbum?.artistId)
    assertThat(destDomainAlbum?.collectionId).isEqualTo(srcPresentationAlbum?.collectionId)
    assertThat(destDomainAlbum?.artistName).isEqualTo(srcPresentationAlbum?.artistName)
    assertThat(destDomainAlbum?.collectionName).isEqualTo(srcPresentationAlbum?.collectionName)
    assertThat(destDomainAlbum?.artistViewUrl).isEqualTo(srcPresentationAlbum?.artistViewUrl)
    assertThat(destDomainAlbum?.collectionViewUrl).isEqualTo(
      srcPresentationAlbum?.collectionViewUrl)
    assertThat(destDomainAlbum?.collectionPrice).isEqualTo(
      srcPresentationAlbum?.collectionPrice)
    assertThat(destDomainAlbum?.trackCount).isEqualTo(srcPresentationAlbum?.trackCount)
    assertThat(destDomainAlbum?.country).isEqualTo(srcPresentationAlbum?.country)
    assertThat(destDomainAlbum?.currency).isEqualTo(srcPresentationAlbum?.currency)
    assertThat(destDomainAlbum?.releaseDate).isEqualTo(srcPresentationAlbum?.releaseDate)
    assertThat(destDomainAlbum?.primaryGenreName).isEqualTo(
      srcPresentationAlbum?.primaryGenreName)
    assertThat(destDomainAlbum?.artWorkThumbnailSmall).isEqualTo(
      srcPresentationAlbum?.artWorkThumbnailSmall)
    assertThat(destDomainAlbum?.artWorkThumbnailLarge).isEqualTo(
      srcPresentationAlbum?.artWorkThumbnailLarge)
  }
}