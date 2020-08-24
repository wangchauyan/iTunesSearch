package idv.chauyan.itunessearch.data

import idv.chauyan.itunessearch.data.model.DataAlbum
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
  fun getAlbumsByKeyword() {
    runBlockingTest {

      val dataArtWorks = listOf<DataAlbum>()
      val keyword = "swift"

      `when`(remoteData.getAlbumsByKeyword(keyword)).thenReturn(dataArtWorks)
      dataRepository.getAlbumsByKeyword(keyword)
      verify(remoteData).getAlbumsByKeyword(keyword)
    }
  }

  @Test
  fun getTracksByAlbumTitle() {
    runBlockingTest {

      val dataArtWorks = listOf<DataAlbum>()
      val albumTitle = "red"

      `when`(remoteData.getTracksByAlbumTitle(albumTitle)).thenReturn(dataArtWorks)
      dataRepository.getTracksByAlbumTitle(albumTitle)
      verify(remoteData).getTracksByAlbumTitle(albumTitle)
    }
  }
}