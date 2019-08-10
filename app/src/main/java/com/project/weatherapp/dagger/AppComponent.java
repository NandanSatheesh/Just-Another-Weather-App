package com.project.weatherapp.dagger;

import com.project.weatherapp.LandingActivity;
import com.project.weatherapp.network.APIService;
import com.project.weatherapp.network.NetworkUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public interface AppComponent {
	void inject(LandingActivity application);

	@Module
	class NetworkModule {

		@Provides
		@Singleton
		APIService getQuotesApiHandler(Retrofit retroFit) {
			return retroFit.create(APIService.class);
		}

		@Provides
		@Singleton
		Retrofit providesRetrofit(OkHttpClient okHttpClient) {
			return new Retrofit.Builder()
					.baseUrl(NetworkUtil.BASE_URL)
					.addConverterFactory(GsonConverterFactory.create())
					.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
					.client(okHttpClient)
					.build();
		}

		@Provides
		@Singleton
		OkHttpClient providesOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
			return new OkHttpClient.Builder()
					.addInterceptor(httpLoggingInterceptor)
					.build();
		}

		@Provides
		@Singleton
		HttpLoggingInterceptor providesHttpLoggingInterceptor() {
			HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
			httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
			return httpLoggingInterceptor;
		}
	}
}
