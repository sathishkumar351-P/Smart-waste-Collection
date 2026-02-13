package com.wipro.swcs.entity;

public class Complaint {
	private String complaintId;
    private String pointId;
    private String date;
    private String description;

    public Complaint(String complaintId, String pointId, String date, String description) {
        this.complaintId = complaintId;
        this.pointId = pointId;
        this.date = date;
        this.description = description;
    }

    public String getPointId() {
        return pointId;
    }

}
