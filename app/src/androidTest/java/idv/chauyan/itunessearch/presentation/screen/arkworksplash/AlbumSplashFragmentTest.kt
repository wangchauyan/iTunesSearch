package idv.chauyan.itunessearch.presentation.screen.arkworksplash

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import idv.chauyan.itunessearch.R
import idv.chauyan.itunessearch.presentation.screen.albumsplash.view.AlbumSplashFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class AlbumSplashFragmentTest {

  @Test
  fun checkSplashLogo() {
    // Create a TestNavHostController
    val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
    navController.setGraph(R.navigation.nav_graph)

    val scenario = launchFragmentInContainer<AlbumSplashFragment>()
    scenario.onFragment {
      Navigation.setViewNavController(it.requireView(), navController)
    }

    // check view display
    onView(ViewMatchers.withId(R.id.music_logo))
      .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    // cause splash screen has a delay handler to navigate into next screen.
    // we need to wait for the handler done.
    Thread.sleep(1000)
  }
}