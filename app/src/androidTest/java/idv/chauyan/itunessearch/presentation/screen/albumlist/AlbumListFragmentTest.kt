package idv.chauyan.itunessearch.presentation.screen.albumlist

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.assertThat
import idv.chauyan.itunessearch.R
import idv.chauyan.itunessearch.mockserver.TestWebServer
import idv.chauyan.itunessearch.presentation.screen.albumlist.view.MockAlbumListFragment
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class AlbumListFragmentTest {

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

  @Test
  fun shouldShowArtWorkListView() {

    var artWorkListView: RecyclerView? = null
    var artWorksCount = 0

    val scenario = launchFragmentInContainer<MockAlbumListFragment>()
    scenario.onFragment {
      artWorkListView = it.activity?.findViewById<RecyclerView>(R.id.list)
    }

    // check view display
    onView(withId(R.id.artwork_search)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    onView(withId(R.id.artwork_search_btn)).check(
      ViewAssertions.matches(ViewMatchers.isDisplayed()))
    onView(withId(R.id.list)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    // search `swift`
    onView(withId(R.id.artwork_search)).perform(typeText("swift"), closeSoftKeyboard())
    onView(withId(R.id.artwork_search_btn)).perform(click())

    artWorksCount = artWorkListView?.adapter?.itemCount ?: 0

    assertThat(artWorkListView).isNotNull()
    assertThat(artWorksCount).isNotNull()
    assertThat(artWorksCount).isEqualTo(1)
  }
}