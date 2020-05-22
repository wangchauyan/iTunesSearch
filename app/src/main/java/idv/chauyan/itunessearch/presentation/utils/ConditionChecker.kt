package idv.chauyan.itunessearch.presentation.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object ConditionChecker {
  fun isNetworkAvailable(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    return activeNetwork?.isConnectedOrConnecting == true
  }
}