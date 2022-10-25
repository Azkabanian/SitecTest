package android.sitectest.di

import android.sitectest.data.SitecApi
import android.sitectest.data.repository.SitecTestRepositoryImpl
import android.sitectest.domain.repository.SitecTestRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): SitecApi {

        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dev.sitec24.ru/UKA_TRADE/hs/MobileClient")
            .client(okHttpClient)
            .build()
            .create(SitecApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSitecSystemRepository(api: SitecApi) : SitecTestRepository {
        return SitecTestRepositoryImpl(api)
    }
}