package idv.chauyan.itunessearch.remote.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import idv.chauyan.itunessearch.remote.model.Albums
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface SearchAPI {

  @GET("search?")
  @JvmSuppressWildcards
  suspend fun getAlbums(
    @QueryMap params: Map<String, String>
  ): Albums

  companion object {
    private const val localServer = "http://127.0.0.1:8000/"
    private const val remoteServer = "https://itunes.apple.com/"
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