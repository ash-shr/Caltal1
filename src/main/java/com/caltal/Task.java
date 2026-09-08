package com.caltal;

public class Task {

    private String name;
    private double latitude;
    private double longitude;
    private int radius;
    private boolean isComplete;

    public Task(String name, double latitude, double longitude, int radius) {
        setName(name);
        setLatitude(latitude);
        setLongitude(longitude);
        setRadius(radius);
        this.isComplete = false;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getRadius() {
        return radius;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.name = name;
    }

    public void setLatitude(double latitude) {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90");
        }
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180");
        }
        this.longitude = longitude;
    }

    public void setRadius(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    public void markComplete() {
        this.isComplete = true;
    }
}