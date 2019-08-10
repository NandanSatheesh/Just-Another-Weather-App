package com.project.weatherapp.dagger.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
	private Application application;

	public MainModule(Application application) {
		this.application = application;
	}

	@Provides
	@Singleton
	public Application providesApplication() {
		return application;
	}

	@Provides
	@Singleton
	public Context providesApplicationContext() {
		return application;
	}
}
