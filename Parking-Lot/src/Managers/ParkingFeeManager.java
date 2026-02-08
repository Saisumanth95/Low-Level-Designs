package Managers;

import Models.Vehicle;
import Models.VehicleType;

import java.time.Instant;
import java.util.Map;

public class ParkingFeeManager {

    Map<VehicleType, Double> vehicleCharges;

    public void setVehicleCharges(Map<VehicleType, Double> vehicleCharges) {
        this.vehicleCharges = vehicleCharges;
    }

    public double generateFees(VehicleType vehicleType, Instant entryTime, Instant exitTime){

        double charge = vehicleCharges.get(vehicleType);

        double amount = exitTime.compareTo(entryTime) * charge;

        return amount;
    }

}
