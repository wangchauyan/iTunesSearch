package idv.chauyan.itunessearch.presentation.screen.artworklist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import idv.chauyan.itunessearch.R
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract

class ArtWorkListFragment : Fragment(), ArtWorkListContract.View {

  // TODO: Rename and change types of parameters
  private var param1: String? = null
  private var param2: String? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_art_work_list, container, false)
  }

  /**
   * Art work list view contract
   */
  override fun setPresenter(presenter: ArtWorkListContract.Presenter) {
  }

  override fun updateArtWorkList() {
  }

}