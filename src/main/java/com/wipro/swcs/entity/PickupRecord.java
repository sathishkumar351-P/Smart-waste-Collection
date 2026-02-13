package com.wipro.swcs.entity;

public class PickupRecord {
	  private String recordId;
	    private String pointId;
	    private String date;
	    private String notes;

	    public PickupRecord(String recordId, String pointId, String date, String notes) {
	        this.recordId = recordId;
	        this.pointId = pointId;
	        this.date = date;
	        this.notes = notes;
	    }

	    public String getPointId() {
	        return pointId;
	    }

}