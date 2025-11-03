package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.LatLong;
import org.ncm.ncmv2.domain.model.WeatherAlert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("weatherDao")
public class WeatherDaoImpl implements WeatherDao {
    @Override
    public WeatherAlert createWeatherAlert(WeatherAlert weatherAlert) {
        return null;
    }

    @Override
    public WeatherAlert getWeatherAlertById(Long id) {
        return null;
    }

    @Override
    public List<WeatherAlert> getAllActiveWeatherAlerts() {
        return List.of();
    }

    @Override
    public List<WeatherAlert> getActiveWeatherAlertsByLatLong(LatLong latLong) {
        return List.of();
    }

    @Override
    public List<WeatherAlert> getActiveWeatherAlertsForNet(Long netId) {
        return List.of();
    }
}
