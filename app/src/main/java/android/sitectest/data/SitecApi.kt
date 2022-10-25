package android.sitectest.data

import android.sitectest.domain.model.UsersResponse
import retrofit2.http.GET

interface SitecApi {

    @GET("/{IMEI}/form/users/")
    suspend fun getUsers(): UsersResponse
}