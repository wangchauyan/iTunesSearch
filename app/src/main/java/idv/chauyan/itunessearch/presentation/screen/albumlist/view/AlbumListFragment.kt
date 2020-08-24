package idv.chauyan.itunessearch.presentation.screen.albumlist.view

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
import idv.chauyan.itunessearch.domain.usecases.GetAlbumsByKeyword
import idv.chauyan.itunessearch.presentation.model.PresentationAlbum
import idv.chauyan.itunessearch.presentation.screen.albumlist.AlbumListContract
import idv.chauyan.itunessearch.presentation.screen.albumlist.model.AlbumListModel
import idv.chauyan.itunessearch.presentation.screen.albumlist.presenter.AlbumListPresenter
import idv.chauyan.itunessearch.presentation.screen.albumlist.view.adpater.AlbumListAdapter
import idv.chauyan.itunessearch.presentation.utils.ConditionChecker
import idv.chauyan.itunessearch.presentation.utils.ErrorHandler

open class AlbumListFragment :
  Fragment(),
  AlbumListContract.View,
  AlbumListContract.View.AlbumListBehavior {

  // customize the recyclerview layout
  private var columnCount = 1

  private lateinit var albumListAdapter: AlbumListAdapter
  private lateinit var presenter: AlbumListContract.Presenter
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
    val model = AlbumListModel(GetAlbumsByKeyword(DomainRepository.create(false)))
    setPresenter(AlbumListPresenter(model, this))
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
    // retrieve the search result when navigating back
    keyword?.let {
      updateAlbumList(this.presenter.getCachedResultByKey(it))
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.cleanCache()
  }

  /**
   * Artwork list view contract
   */
  override fun setPresenter(presenter: AlbumListContract.Presenter) {
    this.presenter = presenter
  }

  override fun updateAlbumList(albums: List<PresentationAlbum>) {
    keyword?.let { this.presenter.cacheSearchResult(it, albums) }
    albumListAdapter.updateArtworks(albums)
  }

  override fun onSelectedAlbum(album: PresentationAlbum) {
    val direction = ArtWorkListFragmentDirections
      .actionArtworkListFragmentToArtWorkDetailFragment(album)
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
      albumListAdapter = AlbumListAdapter(
        context,
        arrayListOf(),
        this@AlbumListFragment
      )

      // properties initialization
      adapter = albumListAdapter
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

        this.presenter.getAlbumsByKeyword(keyword)
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