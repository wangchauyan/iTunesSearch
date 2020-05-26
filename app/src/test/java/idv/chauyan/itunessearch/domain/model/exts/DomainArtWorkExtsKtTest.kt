package idv.chauyan.itunessearch.domain.model.exts

import com.google.common.truth.Truth.assertThat
import idv.chauyan.itunessearch.data.model.DataArtWork
import idv.chauyan.itunessearch.domain.model.DomainArtWork
import org.junit.After
import org.junit.Before
import org.junit.Test

class DomainArtWorkExtsKtTest {

  private var srcDataArtWork: DataArtWork? = null
  private var destDataArtWork: DataArtWork? = null

  private var srcDomainArtWork: DomainArtWork? = null
  private var destDomainArtWork: DomainArtWork? = null

  @Before
  fun setUp() {
    // initialize `data`, `domain` layer artworks
    srcDataArtWork = DataArtWork(
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
    srcDataArtWork = null
    destDataArtWork = null

    srcDomainArtWork = null
    destDomainArtWork = null
  }

  @Test
  fun toDataModel() {
    destDataArtWork = srcDomainArtWork?.toDataModel()
    assertThat(destDataArtWork).isNotNull()
    assertThat(destDataArtWork?.wrapperType).isEqualTo(srcDomainArtWork?.wrapperType)
    assertThat(destDataArtWork?.artistId).isEqualTo(srcDomainArtWork?.artistId)
    assertThat(destDataArtWork?.collectionId).isEqualTo(srcDomainArtWork?.collectionId)
    assertThat(destDataArtWork?.artistName).isEqualTo(srcDomainArtWork?.artistName)
    assertThat(destDataArtWork?.collectionName).isEqualTo(srcDomainArtWork?.collectionName)
    assertThat(destDataArtWork?.artistViewUrl).isEqualTo(srcDomainArtWork?.artistViewUrl)
    assertThat(destDataArtWork?.collectionViewUrl).isEqualTo(srcDomainArtWork?.collectionViewUrl)
    assertThat(destDataArtWork?.collectionPrice).isEqualTo(srcDomainArtWork?.collectionPrice)
    assertThat(destDataArtWork?.trackCount).isEqualTo(srcDomainArtWork?.trackCount)
    assertThat(destDataArtWork?.country).isEqualTo(srcDomainArtWork?.country)
    assertThat(destDataArtWork?.currency).isEqualTo(srcDomainArtWork?.currency)
    assertThat(destDataArtWork?.releaseDate).isEqualTo(srcDomainArtWork?.releaseDate)
    assertThat(destDataArtWork?.primaryGenreName).isEqualTo(srcDomainArtWork?.primaryGenreName)
    assertThat(destDataArtWork?.artWorkThumbnailSmall).isEqualTo(
      srcDomainArtWork?.artWorkThumbnailSmall)
    assertThat(destDataArtWork?.artWorkThumbnailLarge).isEqualTo(
      srcDomainArtWork?.artWorkThumbnailLarge)
  }

  @Test
  fun toDomainModel() {
    destDomainArtWork = srcDataArtWork?.toDomainModel()
    assertThat(destDomainArtWork).isNotNull()
    assertThat(destDomainArtWork?.wrapperType).isEqualTo(srcDataArtWork?.wrapperType)
    assertThat(destDomainArtWork?.artistId).isEqualTo(srcDataArtWork?.artistId)
    assertThat(destDomainArtWork?.collectionId).isEqualTo(srcDataArtWork?.collectionId)
    assertThat(destDomainArtWork?.artistName).isEqualTo(srcDataArtWork?.artistName)
    assertThat(destDomainArtWork?.collectionName).isEqualTo(srcDataArtWork?.collectionName)
    assertThat(destDomainArtWork?.artistViewUrl).isEqualTo(srcDataArtWork?.artistViewUrl)
    assertThat(destDomainArtWork?.collectionViewUrl).isEqualTo(srcDataArtWork?.collectionViewUrl)
    assertThat(destDomainArtWork?.collectionPrice).isEqualTo(srcDataArtWork?.collectionPrice)
    assertThat(destDomainArtWork?.trackCount).isEqualTo(srcDataArtWork?.trackCount)
    assertThat(destDomainArtWork?.country).isEqualTo(srcDataArtWork?.country)
    assertThat(destDomainArtWork?.currency).isEqualTo(srcDataArtWork?.currency)
    assertThat(destDomainArtWork?.releaseDate).isEqualTo(srcDataArtWork?.releaseDate)
    assertThat(destDomainArtWork?.primaryGenreName).isEqualTo(srcDataArtWork?.primaryGenreName)
    assertThat(destDomainArtWork?.artWorkThumbnailSmall).isEqualTo(
      srcDataArtWork?.artWorkThumbnailSmall)
    assertThat(destDomainArtWork?.artWorkThumbnailLarge).isEqualTo(
      srcDataArtWork?.artWorkThumbnailLarge)
  }
}