package idv.chauyan.itunessearch.presentation.screen.artworklist.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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
import idv.chauyan.itunessearch.presentation.utils.ErrorHandler

open class ArtWorkListFragment :
  Fragment(),
  ArtWorkListContract.View,
  ArtWorkListContract.View.ArtWorkListBehavior {

  // customize the recyclerview layout
  private var columnCount = 1

  private lateinit var artWorkListAdapter: ArtWorkListAdapter
  private lateinit var presenter: ArtWorkListContract.Presenter
  private lateinit var artWorkList: RecyclerView
  private lateinit var artWorkRefresher: SwipeRefreshLayout
  private lateinit var artWorkSearch: EditText
  private lateinit var artWorkSearchButton: Button
  private lateinit var artWorkRetrySearch: View
  private lateinit var artWorkContainer: ViewGroup
  private lateinit var artWorkNetworkView: ViewGroup

  private var keyword: String? = null

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
    return initViews(inflater, container)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    // retreive the search result when navigating back
    keyword?.let {
      updateArtWorkList(this.presenter.getCachedResultByKey(it))
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.cleanCache()
  }

  /**
   * Artwork list view contract
   */
  override fun setPresenter(presenter: ArtWorkListContract.Presenter) {
    this.presenter = presenter
  }

  override fun updateArtWorkList(artWorks: List<PresentationArtWork>) {
    keyword?.let { this.presenter.cacheSearchResult(it, artWorks) }
    artWorkListAdapter.updateArtworks(artWorks)
  }

  override fun onSelectedArtWork(artWork: PresentationArtWork) {
    val direction = ArtWorkListFragmentDirections
      .actionArtworkListFragmentToArtWorkDetailFragment(artWork)
    findNavController().navigate(direction)
  }

  /**
   * private functions
   */
  private fun initViews(
    inflater: LayoutInflater,
    container: ViewGroup?
  ): View {

    val view = inflater.inflate(
      R.layout.fragment_art_work_list,
      container,
      false
    )

    // set up artwork recyclerview
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

    // set up artwork search
    artWorkSearch = view.findViewById(R.id.artwork_search)
    artWorkSearch.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(s: Editable?) {
      }

      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
      }

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
      }
    })

    // set up artwork search button
    artWorkSearchButton = view.findViewById(R.id.artwork_search_btn)
    artWorkSearchButton.apply {
      setOnClickListener {
        keyword = artWorkSearch.text.toString()
        keyword?.let { searchArtWork(it) }
      }
    }

    // set up retry search 
    artWorkRetrySearch = view.findViewById(R.id.no_network_retry)
    artWorkRetrySearch.setOnClickListener {
      this.keyword?.let { searchArtWork(it) }
    }

    artWorkContainer = view.findViewById(R.id.artwork_container)
    artWorkNetworkView = view.findViewById(R.id.network_condition)

    return view
  }

  private fun searchArtWork(keyword: String) {
    context?.let {
      if (ConditionChecker.isNetworkAvailable(it)) {
        artWorkContainer.visibility = View.VISIBLE
        artWorkNetworkView.visibility = View.GONE

        this.presenter.getArtWorks(keyword)
      } else {
        artWorkContainer.visibility = View.GONE
        artWorkNetworkView.visibility = View.VISIBLE
        ErrorHandler.showErrorMessage(it, ErrorHandler.ErrorType.NetworkConnectError(
          ErrorHandler.ErrorCode.NetworkError,
          "No network connection!"
        ))
      }
    }
  }
}