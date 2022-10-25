package android.sitectest.data.repository

import android.sitectest.data.SitecApi
import android.sitectest.domain.model.UsersResponse
import android.sitectest.domain.repository.SitecTestRepository
import javax.inject.Inject

class SitecTestRepositoryImpl @Inject constructor(
    private val api : SitecApi
): SitecTestRepository {

    override suspend fun getUsers() = api.getUsers()
}