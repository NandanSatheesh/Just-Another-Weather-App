package com.project.weatherapp.weatherdata;

import android.Manifest;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController;
import com.project.weatherapp.LandingActivity;
import com.project.weatherapp.R;
import com.project.weatherapp.ViewUtils;
import com.project.weatherapp.databinding.ConductorWeatherDataBinding;
import com.project.weatherapp.models.WeatherApiResponse;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.disposables.CompositeDisposable;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class WeatherReportController extends MvpController<WeatherReportContract.View, WeatherReportPresenter>
		implements WeatherReportContract.View {

	private ConductorWeatherDataBinding binding;
	private final int days = 5;
	private RxPermissions rxPermissions;
	private CompositeDisposable compositeDisposable;
	private LocationCallback locationCallback;
	private LocationRequest locationRequest;
	private FusedLocationProviderClient providerClient;
	private boolean mRequestingLocationUpdates = true;
	private String city, DEGREE = "\u00b0";
	private long UPDATE_INTERVAL = 5 * 60 * 1000;  /* 5 min */
	private long FASTEST_INTERVAL = 2000; /* 2 sec */


	@NonNull
	@Override
	protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.conductor_weather_data, container, false);
		compositeDisposable = new CompositeDisposable();
		rxPermissions = new RxPermissions((LandingActivity)getActivity());
		compositeDisposable = new CompositeDisposable();
		providerClient = getFusedLocationProviderClient(getActivity());
		locationRequest = new LocationRequest();
		locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
		locationRequest.setInterval(UPDATE_INTERVAL);
		locationRequest.setFastestInterval(FASTEST_INTERVAL);
		requestPermission();
		return binding.getRoot();
	}

	@Override
	protected void onAttach(@NonNull View view) {
		super.onAttach(view);
	}

	@NonNull
	@Override
	public WeatherReportPresenter getPresenter() {
		return super.getPresenter();
	}

	@NonNull
	@Override
	public WeatherReportPresenter createPresenter() {
		return LandingActivity.getInstance().getGraphComponent().getWeatherReportPresenter();
	}

	@Override
	public void showLoadingView() {
		ViewUtils.setVisible(binding.loadingView);
	}

	@Override
	public void showContentView() {
		ViewUtils.setVisible(binding.contentView);
	}

	@Override
	public void hideLoadingView() {
		ViewUtils.setGone(binding.loadingView);
	}

	@Override
	public void hideContentView() {
		ViewUtils.setGone(binding.contentView);
	}

	@Override
	public void setContent(WeatherApiResponse response) {
		binding.currentTemperature.setText(String.format("%s%s C", response.current.tempC, DEGREE));
		binding.placeName.setText(response.location.name);
		WeatherFutureForecastAdapter adapter = new WeatherFutureForecastAdapter();
		adapter.updateData(response.forecast.forecastday.subList(1, response.forecast.forecastday.size()));
		binding.futureForecast.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
		binding.futureForecast.setAdapter(adapter);
	}

	public void requestPermission() {
		compositeDisposable.add(rxPermissions.requestEach(Manifest.permission.ACCESS_FINE_LOCATION)
				.subscribe(permission -> {
					if (permission.granted) {
						startLocationUpdate();
					} else {
						showPermissionError();
					}
				}));
	}

	private void showPermissionError() {
		Toast.makeText(getApplicationContext(), "Allow access to location for weather data", Toast.LENGTH_SHORT).show();
	}

	public void startLocationUpdate() {
		if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
				!= PackageManager.PERMISSION_GRANTED
				&& ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
				!= PackageManager.PERMISSION_GRANTED) {
			requestPermission();
			return;
		}
		locationCallback = new LocationCallback() {
			@Override
			public void onLocationResult(LocationResult locationResult) {
				if (locationResult == null) {
					return;
				}
				if (mRequestingLocationUpdates) {
					mRequestingLocationUpdates = false;
					city = locationResult.getLastLocation().getLatitude() + ","
							+ locationResult.getLastLocation().getLongitude();
					fetchWeatherData();
				}
				stopLocationRequest();
			}
		};
		providerClient.requestLocationUpdates(locationRequest, locationCallback, null);
	}

	private void fetchWeatherData() {
		getPresenter().getWeatherForcastData(city, days);
	}

	public void stopLocationRequest() {
		providerClient.removeLocationUpdates(locationCallback);
	}
}
