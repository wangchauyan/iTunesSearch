package idv.chauyan.itunessearch.presentation.screen.artworklist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import idv.chauyan.itunessearch.R
import idv.chauyan.itunessearch.domain.DomainRepository
import idv.chauyan.itunessearch.domain.usecases.GetArtWorks
import idv.chauyan.itunessearch.presentation.model.PresentationArtWork
import idv.chauyan.itunessearch.presentation.screen.artworklist.ArtWorkListContract
import idv.chauyan.itunessearch.presentation.screen.artworklist.model.ArtWorkListModel
import idv.chauyan.itunessearch.presentation.screen.artworklist.presenter.ArtWorkListPresenter
import idv.chauyan.itunessearch.presentation.screen.artworklist.view.adpater.ArtWorkListAdapter
import idv.chauyan.itunessearch.presentation.utils.ConditionChecker
import idv.chauyan.itunessearch.presentation.utils.Configuration
import idv.chauyan.itunessearch.presentation.utils.ErrorHandler

class ArtWorkListFragment :
  Fragment(),
  ArtWorkListContract.View,
  ArtWorkListContract.View.ArtWorkListBehavior {

  // customize the recyclerview layout
  private var columnCount = 1

  private lateinit var artWorkListAdapter: ArtWorkListAdapter
  private lateinit var presenter: ArtWorkListContract.Presenter
  private lateinit var artWorkList: RecyclerView
  private lateinit var artWorkRefresher: SwipeRefreshLayout
  private lateinit var artWorkNetworkView: ViewGroup

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val model = ArtWorkListModel(GetArtWorks(DomainRepository.create(false)))
    setPresenter(ArtWorkListPresenter(model, this))
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(
      R.layout.fragment_art_work_list,
      container,
      false
    )

    artWorkList = view.findViewById(R.id.list)
    artWorkList.apply {
      // init artwork list adapter
      artWorkListAdapter = ArtWorkListAdapter(arrayListOf(), this@ArtWorkListFragment)

      // properties initialization
      adapter = artWorkListAdapter
      layoutManager = when {
        columnCount <= 1 -> LinearLayoutManager(activity)
        else -> GridLayoutManager(activity, columnCount)
      }
    }

    // set up artwork refresher
    artWorkRefresher = view.findViewById(R.id.refresher)
    artWorkRefresher.apply {
      setOnRefreshListener {
        artWorkRefresher.isRefreshing = false
      }
    }
    artWorkNetworkView = view.findViewById(R.id.network_condition)
    return view
  }

  override fun onResume() {
    super.onResume()
    context?.let {
      if (ConditionChecker.isNetworkAvailable(it)) {
        artWorkRefresher.visibility = View.VISIBLE
        artWorkNetworkView.visibility = View.GONE

        this.presenter.getArtWorks()
      } else {
        artWorkRefresher.visibility = View.GONE
        artWorkNetworkView.visibility = View.VISIBLE
        ErrorHandler.showErrorMessage(it, ErrorHandler.ErrorType.NetworkConnectError(
          ErrorHandler.ErrorCode.NetworkError,
          "No network connection!"
        ))
      }
    }
  }

  /**
   * Artwork list view contract
   */
  override fun setPresenter(presenter: ArtWorkListContract.Presenter) {
    this.presenter = presenter
  }

  override fun updateArtWorkList(artWorks: List<PresentationArtWork>) {
    artWorkListAdapter.updateArtworks(artWorks, false)
  }

  override fun onSelectedArtWork(artWork: PresentationArtWork) {
    val direction = ArtWorkListFragmentDirections
      .actionArtworkListFragmentToArtWorkDetailFragment(artWork)
    findNavController().navigate(direction)
  }
}