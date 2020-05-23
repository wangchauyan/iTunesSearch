package idv.chauyan.itunessearch.presentation.screen.artworksplash.view

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import idv.chauyan.itunessearch.R
import kotlinx.android.synthetic.main.fragment_art_work_splash.*

/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class ArtWorkSplashFragment : Fragment() {

  private val hideHandler = Handler()
  private val enterHandler = Handler()

  @Suppress("InlinedApi")
  private val hideStatusBarRunner = Runnable {
    // Delayed removal of status and navigation bar

    // Note that some of these constants are new as of API 16 (Jelly Bean)
    // and API 19 (KitKat). It is safe to use them, as they are inlined
    // at compile-time and do nothing on earlier devices.
    val flags =
      View.SYSTEM_UI_FLAG_LOW_PROFILE or
          View.SYSTEM_UI_FLAG_FULLSCREEN or
          View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
          View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
          View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
          View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    activity?.window?.decorView?.systemUiVisibility = flags
    (activity as? AppCompatActivity)?.supportActionBar?.hide()
  }

  private val hideRunnable = Runnable { hide() }
  private val enterRunnable = Runnable {
    findNavController().navigate(
      R.id.action_ArtWorkSplashFragment_to_ArtworkListFragment,
      null,
      NavOptions.Builder()
        .setPopUpTo(R.id.ArtWorkSplashFragment,
          true).build()
    )
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_art_work_splash, container, false)
  }

  override fun onResume() {
    super.onResume()
    activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

    delayedHide(100)
    delayedEnter(200)
  }

  override fun onPause() {
    super.onPause()
    activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

    // Clear the systemUiVisibility flag
    activity?.window?.decorView?.systemUiVisibility = 0
    show()
  }

  private fun hide() {
    // Schedule a runnable to remove the status and navigation bar after a delay
    hideHandler.postDelayed(hideStatusBarRunner, UI_ANIMATION_DELAY.toLong())
  }

  @Suppress("InlinedApi")
  private fun show() {
    // Show the system bar
    music_logo.systemUiVisibility =
      View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
          View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

    // Schedule a runnable to display UI elements after a delay
    hideHandler.removeCallbacks(hideStatusBarRunner)
    (activity as? AppCompatActivity)?.supportActionBar?.show()
  }

  /**
   * Schedules a call to hide() in [delayMillis], canceling any
   * previously scheduled calls.
   */
  private fun delayedHide(delayMillis: Int) {
    hideHandler.removeCallbacks(hideRunnable)
    hideHandler.postDelayed(hideRunnable, delayMillis.toLong())
  }

  /**
   * Schedules a call to enter into `ArtWorKListFragment`.
   */
  private fun delayedEnter(delayMillis: Int) {
    enterHandler.postDelayed(enterRunnable, delayMillis.toLong())
  }

  companion object {
    /**
     * Whether or not the system UI should be auto-hidden after
     * [AUTO_HIDE_DELAY_MILLIS] milliseconds.
     */
    private const val AUTO_HIDE = true

    /**
     * If [AUTO_HIDE] is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private const val AUTO_HIDE_DELAY_MILLIS = 3000

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private const val UI_ANIMATION_DELAY = 300
  }
}