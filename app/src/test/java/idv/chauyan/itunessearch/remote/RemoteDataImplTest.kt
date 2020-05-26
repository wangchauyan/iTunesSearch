package idv.chauyan.itunessearch.remote

import idv.chauyan.itunessearch.remote.api.SearchAPI
import idv.chauyan.itunessearch.remote.model.ArtWorks
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RemoteDataImplTest {

  @Mock
  private lateinit var searchAPI: SearchAPI

  @InjectMocks
  private lateinit var remoteDataImpl: RemoteDataImpl

  @ExperimentalCoroutinesApi
  @Test
  fun getAlbumsByKeyword() {
    runBlockingTest {
      val remoteArtWorks = ArtWorks(
        resultCount = 0,
        results = listOf()
      )
      val keyword = "swift"
      val params = mapOf(
        "term" to keyword,
        "entity" to "album"
      )

      `when`(searchAPI.getArtWorks(params)).thenReturn(remoteArtWorks)
      remoteDataImpl.getAlbumsByKeyword(keyword)
      verify(searchAPI).getArtWorks(params)
    }
  }

  @ExperimentalCoroutinesApi
  @Test
  fun getTracksByAlbumTitle() {
    runBlockingTest {
      val remoteArtWorks = ArtWorks(
        resultCount = 0,
        results = listOf()
      )
      val albumTitle = "red"
      val params = mapOf(
        "term" to albumTitle,
        "entity" to "song",
        "attribute" to "albumTerm",
        "limit" to "10000"
      )

      `when`(searchAPI.getArtWorks(params)).thenReturn(remoteArtWorks)
      remoteDataImpl.getTracksByAlbumTitle(albumTitle)
      verify(searchAPI).getArtWorks(params)
    }
  }
}