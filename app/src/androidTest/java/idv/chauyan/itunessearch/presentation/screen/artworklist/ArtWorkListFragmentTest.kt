package idv.chauyan.itunessearch.presentation.screen.artworklist

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import idv.chauyan.itunessearch.mockserver.TestWebServer
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class ArtWorkListFragmentTest {

  private lateinit var testWebServer: TestWebServer

  @Before
  fun setUp() {
    testWebServer = TestWebServer()
    testWebServer.onStart()
  }

  @After
  fun tearDown() {
    testWebServer.onDestroy()
  }
}