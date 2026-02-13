package com.wipro.swcs.entity;

public class Vehicle {
	private String vehicleId;
    private String driverName;
    private String routeName;

    public Vehicle(String vehicleId, String driverName, String routeName) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.routeName = routeName;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getRouteName() {
        return routeName;
    }

}
