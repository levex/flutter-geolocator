package com.baseflow.geolocator.location;

import android.os.Build;

import java.util.HashMap;
import java.util.Map;

public class LocationMapper {
  @SuppressWarnings("deprecation")
  public static Map<String, Object> toHashMap(android.location.Location location) {
    if (location == null) {
      return null;
    }

    Map<String, Object> position = new HashMap<>();

    position.put("latitude", location.getLatitude());
    position.put("longitude", location.getLongitude());
    position.put("timestamp", location.getTime());

    if (location.hasAltitude()) position.put("altitude", location.getAltitude());
    if (location.hasAccuracy()) position.put("accuracy", (double) location.getAccuracy());
    if (location.hasBearing()) position.put("heading", (double) location.getBearing());
    if (location.hasSpeed()) position.put("speed", (double) location.getSpeed());
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && location.hasSpeedAccuracy())
      position.put("speed_accuracy", (double) location.getSpeedAccuracyMetersPerSecond());

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
      //@SuppressWarnings("deprecation")
      position.put("is_mocked", location.isFromMockProvider());
    } else {
      //@SuppressWarnings("deprecation")
      position.put("is_mocked", false);
    }

    return position;
  }
}
