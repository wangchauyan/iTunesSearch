package idv.chauyan.itunessearch.remote.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface SearchAPI {

  suspend fun getArtWorks()

  companion object {
    private val localServer = "https://127.0.0.1"
    private val remoteServer = "https://itunes.apple.com/search?"
    fun create(debug: Boolean): SearchAPI {
      val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

      return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(if (debug) localServer else remoteServer)
        .build()
        .create(SearchAPI::class.java)
    }
  }
}