package Managers;

import Models.ParkingSpot;
import Models.Vehicle;
import Models.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpotsManager {

    private Map<VehicleType, List<ParkingSpot>> parkingSpotsByType;

    public ParkingSpotsManager() {
        this.parkingSpotsByType = new HashMap<>();
    }


    public void addParkingSpots(ParkingSpot parkingSpot) {
        if(!parkingSpotsByType.containsKey(parkingSpot.getVehicleType())){
            parkingSpotsByType.put(parkingSpot.getVehicleType(), new ArrayList<>());
        }
        parkingSpotsByType.get(parkingSpot.getVehicleType()).add(parkingSpot);
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){

        for(ParkingSpot spot : parkingSpotsByType.get(vehicle.getVehicleType())){
            if(!spot.isOccupied()){
                spot.setOccupied(true);
                return spot;
            }
        }
        return null;
    }

    public void unParkVehicle(ParkingSpot parkingSpot){
        parkingSpot.setOccupied(false);
    }

}
