package com.example.vrakapp;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MyLocationListener implements LocationListener {

	double lon;
	double lat;
	
	@Override
	public void onLocationChanged(Location location) {
		if (location != null) {
			lat = location.getLatitude();
			lon = location.getLongitude();
		}
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

}
