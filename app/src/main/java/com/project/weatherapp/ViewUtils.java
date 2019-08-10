package com.project.weatherapp;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ViewUtils {

	public static void makeToastShort(Context context, String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	public static void makeToastLong(Context context, String message) {
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}

	public static void setVisibility(View view, int visibility) {
		if (view != null) {
			view.setVisibility(visibility);
		}
	}

	public static void setGone(View... views) {
		if (views == null) {
			return;
		}
		for (View view : views) {
			setVisibility(view, View.GONE);
		}
	}

	public static void setVisible(View... views) {
		if (views == null) {
			return;
		}
		for (View view : views) {
			setVisibility(view, View.VISIBLE);
		}
	}

	public static void showLoadingDataSnackbar(View view, String text) {
		Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();

	}
}
