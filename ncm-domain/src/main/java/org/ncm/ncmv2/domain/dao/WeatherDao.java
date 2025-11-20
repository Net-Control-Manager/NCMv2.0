package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.LatLong;
import org.ncm.ncmv2.domain.model.WeatherAlert;

import java.util.List;

public interface WeatherDao {
    WeatherAlert createWeatherAlert(WeatherAlert weatherAlert);

    WeatherAlert getWeatherAlertById(Long id);
    List<WeatherAlert> getAllActiveWeatherAlerts();
    List<WeatherAlert> getActiveWeatherAlertsByLatLong(LatLong latLong);
    List<WeatherAlert> getActiveWeatherAlertsForNet(Long netId);
}
