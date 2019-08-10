package com.project.weatherapp.dagger;

import android.app.Application;

import com.project.weatherapp.dagger.modules.MainModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class, AppComponent.NetworkModule.class})
public interface Graph extends AppComponent, ModuleComponent {

	final class Initializer {
		public static Graph initialize(Application application) {
			return DaggerGraph.builder()
					.mainModule(new MainModule(application))
					.build();
		}
	}
}
