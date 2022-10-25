package android.sitectest.domain.repository

import android.sitectest.domain.model.UsersResponse

interface SitecTestRepository {
    suspend fun getUsers():UsersResponse
}