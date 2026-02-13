package com.wipro.swcs.entity;

public class CollectionPoint {
	private String pointId;
    private String areaName;
    private String status; // PENDING, COLLECTED, MISSED

    public CollectionPoint(String pointId, String areaName, String status) {
        this.pointId = pointId;
        this.areaName = areaName;
        this.status = status;
    }

    public String getPointId() {
        return pointId;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
