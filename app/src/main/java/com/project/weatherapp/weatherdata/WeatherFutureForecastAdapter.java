package com.project.weatherapp.weatherdata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.weatherapp.DateUtil;
import com.project.weatherapp.R;
import com.project.weatherapp.databinding.ItemFutureForecastBinding;
import com.project.weatherapp.models.ForecastDay;

import java.util.ArrayList;
import java.util.List;

public class WeatherFutureForecastAdapter extends RecyclerView.Adapter<WeatherFutureForecastAdapter.FutureForecastViewHolder> {

	private ItemFutureForecastBinding binding;
	private List<ForecastDay> forecastDayList;
	private String DEGREE = "\u00b0";

	public WeatherFutureForecastAdapter() {
		forecastDayList = new ArrayList<>();
	}

	public void updateData(List<ForecastDay> forecastDays) {
		forecastDayList.clear();
		forecastDayList.addAll(forecastDays);
		notifyDataSetChanged();
	}

	@NonNull
	@Override
	public WeatherFutureForecastAdapter.FutureForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_future_forecast, parent, false);
		return new FutureForecastViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(@NonNull WeatherFutureForecastAdapter.FutureForecastViewHolder holder, int position) {
		holder.bindData(forecastDayList.get(position));
	}

	@Override
	public int getItemCount() {
		return forecastDayList.size();
	}

	public class FutureForecastViewHolder extends RecyclerView.ViewHolder {

		private ItemFutureForecastBinding binding;

		public FutureForecastViewHolder(@NonNull View itemView) {
			super(itemView);
		}

		public FutureForecastViewHolder(ItemFutureForecastBinding binding) {
			super(binding.getRoot());
			this.binding = binding;
		}

		public void bindData(ForecastDay forecastDay) {
			binding.dayOfTheWeek.setText(DateUtil.getDayFromDate(forecastDay.date));
			binding.forecastTemperature.setText(String.format("%s%s C", forecastDay.day.avgtempC, DEGREE));

		}
	}
}
