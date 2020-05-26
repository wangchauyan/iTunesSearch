package idv.chauyan.itunessearch.presentation.screen.artworklist.view

import android.os.Bundle
import idv.chauyan.itunessearch.domain.DomainRepository
import idv.chauyan.itunessearch.domain.usecases.GetAlbumsByKeyword
import idv.chauyan.itunessearch.presentation.screen.artworklist.model.MockArtWorkListModel
import idv.chauyan.itunessearch.presentation.screen.artworklist.presenter.MockArtWorkListPresenter

class MockArtWorkListFragment : ArtWorkListFragment() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // setup mock presenter and enable the debug mode
    val model = MockArtWorkListModel(GetAlbumsByKeyword(DomainRepository.create(true)))
    setPresenter(MockArtWorkListPresenter(model, this))
  }
}