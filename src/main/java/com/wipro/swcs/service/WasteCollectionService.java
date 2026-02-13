package com.wipro.swcs.service;

	import java.util.ArrayList;

	import com.wipro.swcs.entity.*;
	import com.wipro.swcs.util.*;

	public class WasteCollectionService {

	    private ArrayList<Vehicle> vehicles;
	    private ArrayList<CollectionPoint> points;
	    private ArrayList<PickupRecord> pickups;
	    private ArrayList<Complaint> complaints;

	    public WasteCollectionService(ArrayList<Vehicle> vehicles,
	                                  ArrayList<CollectionPoint> points,
	                                  ArrayList<PickupRecord> pickups,
	                                  ArrayList<Complaint> complaints) {
	        this.vehicles = vehicles;
	        this.points = points;
	        this.pickups = pickups;
	        this.complaints = complaints;
	    }

	    public CollectionPoint findCollectionPoint(String pointId)
	            throws CollectionPointNotFoundException {
	        for (CollectionPoint cp : points) {
	            if (cp.getPointId().equals(pointId)) {
	                return cp;
	            }
	        }
	        throw new CollectionPointNotFoundException("Collection Point not found");
	    }

	    public void markPickup(String recordId, String pointId, String date, String notes)
	            throws CollectionPointNotFoundException, InvalidOperationException {

	        CollectionPoint cp = findCollectionPoint(pointId);

	        if (cp.getStatus().equals("COLLECTED")) {
	            throw new InvalidOperationException("Pickup already done");
	        }

	        pickups.add(new PickupRecord(recordId, pointId, date, notes));
	        cp.setStatus("COLLECTED");
	    }

	    public void markMissedPickup(String pointId, String reason)
	            throws CollectionPointNotFoundException, InvalidOperationException {

	        if (reason == null || reason.isEmpty()) {
	            throw new InvalidOperationException("Reason cannot be empty");
	        }

	        CollectionPoint cp = findCollectionPoint(pointId);
	        cp.setStatus("MISSED");
	    }

	    public void registerComplaint(Complaint c)
	            throws CollectionPointNotFoundException {
	        findCollectionPoint(c.getPointId());
	        complaints.add(c);
	    }

	    public String generateDailySummary() {
	        int collected = 0, missed = 0;

	        for (CollectionPoint cp : points) {
	            if (cp.getStatus().equals("COLLECTED")) collected++;
	            if (cp.getStatus().equals("MISSED")) missed++;
	        }

	        return "Collected: " + collected +
	               "\nMissed: " + missed +
	               "\nComplaints: " + complaints.size();
	    }

}
