package idv.chauyan.itunessearch.presentation.screen.artworklist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import idv.chauyan.itunessearch.R
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract
import idv.chauyan.itunessearch.presentation.screen.artworklist.view.adpater.ArtWorkListAdapter

class ArtWorkListFragment : Fragment(), ArtWorkListContract.View {

  // customize the recyclerview layout
  private var columnCount = 1
  private var refreshing = false
  private var loadMore = false
  private val pageSize = 10
  private var since = 0

  private var listener: ArtWorkListContract.View.ArtWorkListBehavior? = null
  private lateinit var artWorkListAdapter: ArtWorkListAdapter
  private lateinit var presenter: ArtWorkListContract.Presenter
  private lateinit var artWorkList: RecyclerView
  private lateinit var refresher: SwipeRefreshLayout

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
    this.presenter = presenter
  }

  override fun updateArtWorkList(artWorks: List<PresentationArtWork>) {
    artWorks.forEach {
      println("track name : ".plus(it.trackName))
    }
  }

}