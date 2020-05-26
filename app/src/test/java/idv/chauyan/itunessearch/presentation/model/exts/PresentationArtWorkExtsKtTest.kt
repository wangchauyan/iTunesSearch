package idv.chauyan.itunessearch.presentation.model.exts

import com.google.common.truth.Truth.assertThat
import idv.chauyan.itunessearch.domain.model.DomainArtWork
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import org.junit.After
import org.junit.Before
import org.junit.Test

class PresentationArtWorkExtsKtTest {

  private var srcPresentationArtWork: PresentationArtWork? = null
  private var destPresentationArtWork: PresentationArtWork? = null

  private var srcDomainArtWork: DomainArtWork? = null
  private var destDomainArtWork: DomainArtWork? = null

  @Before
  fun setUp() {
    // initialize `data`, `domain` layer artworks
    srcPresentationArtWork = PresentationArtWork(
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

    srcDomainArtWork = DomainArtWork(
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
    srcPresentationArtWork = null
    destPresentationArtWork = null

    srcDomainArtWork = null
    destDomainArtWork = null
  }

  @Test
  fun toDataModel() {
    destPresentationArtWork = srcDomainArtWork?.toPresentationModel()
    assertThat(destPresentationArtWork).isNotNull()
    assertThat(destPresentationArtWork?.wrapperType).isEqualTo(srcDomainArtWork?.wrapperType)
    assertThat(destPresentationArtWork?.artistId).isEqualTo(srcDomainArtWork?.artistId)
    assertThat(destPresentationArtWork?.collectionId).isEqualTo(srcDomainArtWork?.collectionId)
    assertThat(destPresentationArtWork?.artistName).isEqualTo(srcDomainArtWork?.artistName)
    assertThat(destPresentationArtWork?.collectionName).isEqualTo(srcDomainArtWork?.collectionName)
    assertThat(destPresentationArtWork?.artistViewUrl).isEqualTo(srcDomainArtWork?.artistViewUrl)
    assertThat(destPresentationArtWork?.collectionViewUrl).isEqualTo(
      srcDomainArtWork?.collectionViewUrl)
    assertThat(destPresentationArtWork?.collectionPrice).isEqualTo(
      srcDomainArtWork?.collectionPrice)
    assertThat(destPresentationArtWork?.trackCount).isEqualTo(srcDomainArtWork?.trackCount)
    assertThat(destPresentationArtWork?.country).isEqualTo(srcDomainArtWork?.country)
    assertThat(destPresentationArtWork?.currency).isEqualTo(srcDomainArtWork?.currency)
    assertThat(destPresentationArtWork?.releaseDate).isEqualTo(srcDomainArtWork?.releaseDate)
    assertThat(destPresentationArtWork?.primaryGenreName).isEqualTo(
      srcDomainArtWork?.primaryGenreName)
    assertThat(destPresentationArtWork?.artWorkThumbnailSmall).isEqualTo(
      srcDomainArtWork?.artWorkThumbnailSmall)
    assertThat(destPresentationArtWork?.artWorkThumbnailLarge).isEqualTo(
      srcDomainArtWork?.artWorkThumbnailLarge)
  }

  @Test
  fun toDomainModel() {
    destDomainArtWork = srcPresentationArtWork?.toDomainModel()
    assertThat(destDomainArtWork).isNotNull()
    assertThat(destDomainArtWork?.wrapperType).isEqualTo(srcPresentationArtWork?.wrapperType)
    assertThat(destDomainArtWork?.artistId).isEqualTo(srcPresentationArtWork?.artistId)
    assertThat(destDomainArtWork?.collectionId).isEqualTo(srcPresentationArtWork?.collectionId)
    assertThat(destDomainArtWork?.artistName).isEqualTo(srcPresentationArtWork?.artistName)
    assertThat(destDomainArtWork?.collectionName).isEqualTo(srcPresentationArtWork?.collectionName)
    assertThat(destDomainArtWork?.artistViewUrl).isEqualTo(srcPresentationArtWork?.artistViewUrl)
    assertThat(destDomainArtWork?.collectionViewUrl).isEqualTo(
      srcPresentationArtWork?.collectionViewUrl)
    assertThat(destDomainArtWork?.collectionPrice).isEqualTo(
      srcPresentationArtWork?.collectionPrice)
    assertThat(destDomainArtWork?.trackCount).isEqualTo(srcPresentationArtWork?.trackCount)
    assertThat(destDomainArtWork?.country).isEqualTo(srcPresentationArtWork?.country)
    assertThat(destDomainArtWork?.currency).isEqualTo(srcPresentationArtWork?.currency)
    assertThat(destDomainArtWork?.releaseDate).isEqualTo(srcPresentationArtWork?.releaseDate)
    assertThat(destDomainArtWork?.primaryGenreName).isEqualTo(
      srcPresentationArtWork?.primaryGenreName)
    assertThat(destDomainArtWork?.artWorkThumbnailSmall).isEqualTo(
      srcPresentationArtWork?.artWorkThumbnailSmall)
    assertThat(destDomainArtWork?.artWorkThumbnailLarge).isEqualTo(
      srcPresentationArtWork?.artWorkThumbnailLarge)
  }
}