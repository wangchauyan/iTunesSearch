package idv.chauyan.itunessearch.data

import idv.chauyan.itunessearch.data.model.DataArtWork
import idv.chauyan.itunessearch.data.respository.RemoteData
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
class DataRepositoryTest {

  @Mock
  private lateinit var remoteData: RemoteData

  @InjectMocks
  private lateinit var dataRepository: DataRepository

  @ExperimentalCoroutinesApi
  @Test
  fun getArtWorks() {
    runBlockingTest {

      val dataArtWorks = listOf<DataArtWork>()
      val keyword = "swift"

      `when`(remoteData.getArtWorks(keyword)).thenReturn(dataArtWorks)
      dataRepository.getArtWorks(keyword)
      verify(remoteData).getArtWorks(keyword)
    }
  }
}