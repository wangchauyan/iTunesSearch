package idv.chauyan.itunessearch.domain.usecases

import idv.chauyan.itunessearch.domain.DomainRepository
import idv.chauyan.itunessearch.domain.model.DomainArtWork
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
class GetArtWorksTest {

  @Mock
  private lateinit var domainRepository: DomainRepository

  @InjectMocks
  private lateinit var getArtWorks: GetArtWorks

  @ExperimentalCoroutinesApi
  @Test
  fun get() {
    runBlockingTest {

      val domainArtWorks = listOf<DomainArtWork>()
      val keyword = "swift"

      `when`(domainRepository.getArtWorks(keyword)).thenReturn(domainArtWorks)
      getArtWorks.get(keyword)
      verify(domainRepository).getArtWorks(keyword)
    }
  }
}