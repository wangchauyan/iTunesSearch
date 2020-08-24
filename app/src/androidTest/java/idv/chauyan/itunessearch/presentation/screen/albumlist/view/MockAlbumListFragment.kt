package idv.chauyan.itunessearch.presentation.screen.albumlist.view

import android.os.Bundle
import idv.chauyan.itunessearch.domain.DomainRepository
import idv.chauyan.itunessearch.domain.usecases.GetAlbumsByKeyword
import idv.chauyan.itunessearch.presentation.screen.albumlist.model.MockArtWorkListModel
import idv.chauyan.itunessearch.presentation.screen.albumlist.presenter.MockArtWorkListPresenter

class MockAlbumListFragment : AlbumListFragment() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // setup mock presenter and enable the debug mode
    val model = MockArtWorkListModel(GetAlbumsByKeyword(DomainRepository.create(true)))
    setPresenter(MockArtWorkListPresenter(model, this))
  }
}