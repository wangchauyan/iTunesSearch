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
  fun getArtWorks() {
    runBlockingTest {
      val remoteArtWorks = ArtWorks(
        resultCount = 0,
        results = listOf()
      )
      val keyword = "swift"
      val params = mapOf("term" to keyword)

      `when`(searchAPI.getArtWorks(params)).thenReturn(remoteArtWorks)
      remoteDataImpl.getArtWorks(keyword)
      verify(searchAPI).getArtWorks(params)
    }
  }
}