package com.wipro.swcs.main;

import java.util.ArrayList;

import com.wipro.swcs.entity.*;
import com.wipro.swcs.service.WasteCollectionService;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("V001", "Ramesh Kumar", "Route-A"));

        ArrayList<CollectionPoint> points = new ArrayList<>();
        points.add(new CollectionPoint("P001", "MG Road", "PENDING"));
        points.add(new CollectionPoint("P002", "Park Street", "PENDING"));

        WasteCollectionService service =
                new WasteCollectionService(vehicles, points,
                        new ArrayList<>(), new ArrayList<>());

        try {
            service.markPickup("R001", "P001", "2025-08-10", "Collected");
            service.markMissedPickup("P002", "Road blocked");

            System.out.println(service.generateDailySummary());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}