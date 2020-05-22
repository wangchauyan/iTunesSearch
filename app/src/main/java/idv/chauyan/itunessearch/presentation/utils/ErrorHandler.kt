package idv.chauyan.itunessearch.presentation.utils

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast

object ErrorHandler {
  enum class ErrorCode {
    InternalError,
    NetworkError,
    UnknownError
  }

  sealed class ErrorType {
    data class GeneralError(val code: ErrorCode, val errorMsg: String) : ErrorType()
    data class NetworkConnectError(val code: ErrorCode, val errorMsg: String) : ErrorType()
  }

  fun showErrorMessage(
    context: Context,
    error: ErrorType
  ) {
    val alertDialog = AlertDialog.Builder(context)
    when (error) {
      is ErrorType.GeneralError -> {
        alertDialog.setMessage(error.errorMsg)
      }
      is ErrorType.NetworkConnectError -> {
        alertDialog.setMessage("Network Error : ".plus(error.errorMsg))
      }
    }
    alertDialog.setCancelable(true)
    alertDialog.show()
  }
}