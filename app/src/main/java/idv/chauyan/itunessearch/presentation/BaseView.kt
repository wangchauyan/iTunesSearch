package idv.chauyan.itunessearch.presentation

interface BaseView<in p : BasePresenter> {
  fun setPresenter(presenter: p)
}