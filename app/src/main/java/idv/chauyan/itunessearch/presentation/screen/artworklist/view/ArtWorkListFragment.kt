package idv.chauyan.itunessearch.presentation.screen.artworklist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    val model = ArtWorkListModel(GetArtWorks(DomainRepository.create(false)))
    setPresenter(ArtWorkListPresenter(model, this))
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_art_work_list, container, false)
  }

  override fun onResume() {
    super.onResume()
    this.presenter.getArtWorks()
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