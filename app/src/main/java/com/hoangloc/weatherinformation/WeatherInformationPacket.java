package com.hoangloc.weatherinformation;

/**
 * Created by NguyenHoangLoc on 3/28/2018.
 */

public class WeatherInformationPacket {
    public String cityID;
    public String cityName;
    public long time;
    public long lastUpdatedTime;
    public long sunriseTime;
    public long sunsetTime;
    public long latitude;
    public long longitude;
    public double currentTemperature;
    public double maxTemperature;
    public double minTemperature;
    public double humidity;
    public double rainVolume;
    public double windSpeed;
    public String windDirection;
    public double cloudiness;
    public double visibility;
    public String weatherDescription;

    public WeatherInformationPacket(){
        cityID ="";
        cityName = " ";
        time = 0;
        lastUpdatedTime = 0;
        sunriseTime = 0;
        sunsetTime = 0;
        latitude = 0;
        longitude = 0;
        currentTemperature = 0;
        minTemperature = 0;
        maxTemperature = 0;
        humidity = 0;
        rainVolume =0;
        windSpeed = 0;
        windDirection = "";
        cloudiness = 0;
        visibility = 0;
        weatherDescription = "";
    }

    public WeatherInformationPacket(String cityID, String cityName, long time, long lastUpdatedTime,
                                    long sunriseTime, long sunsetTime, long latitude, long longitude,
                                    double currentTemperature, double minTemperature, double maxTemperature,
                                    double humidity, double rainVolume ,double windSpeed, String windDirection,
                                    double cloudiness, double visibility, String weatherDescription){
        this.cityID = cityID;
        this.cityName = cityName;
        this.time = time;
        this.lastUpdatedTime = lastUpdatedTime;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.currentTemperature = currentTemperature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.humidity = humidity;
        this.rainVolume = rainVolume;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.cloudiness = cloudiness;
        this.visibility = visibility;
        this.weatherDescription = weatherDescription;
    }
}
