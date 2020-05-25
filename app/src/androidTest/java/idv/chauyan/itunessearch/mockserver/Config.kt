package idv.chauyan.itunessearch.mockserver

import androidx.test.platform.app.InstrumentationRegistry
import java.io.BufferedReader

/**
 * Provide mock data to mock web server
 */
object Config {

  /**
   * Return a mock artwork list as a mock response body
   */
  fun getArtworks(): String {
    val inputStream = InstrumentationRegistry
      .getInstrumentation()
      .context
      .assets
      .open("sample.json")
    return inputStream.bufferedReader().use(BufferedReader::readText)
  }
}