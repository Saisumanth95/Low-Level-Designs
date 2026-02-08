import Models.ParkingSpot;
import Models.ParkingTicket;
import Models.Vehicle;
import Models.VehicleType;
import ParkingLot.ParkingLot;
import Payments.CashPayment;
import Payments.CreditCardPayment;

import java.util.HashMap;



public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();
        addParkingSpots(parkingLot);
        addFees(parkingLot);

        try {
            ParkingTicket parkingTicket1 = parkingLot.allocateParking(new Vehicle(VehicleType.BIKE, "AP36AE2124"));
            ParkingTicket parkingTicket2 = parkingLot.allocateParking(new Vehicle(VehicleType.CAR, "TS03EL3741"));
            Thread.sleep(Long.parseLong("1000"));
            parkingLot.deAllocateParking(parkingTicket1, new CashPayment());
            Thread.sleep(Long.parseLong("1000"));
            ParkingTicket parkingTicket3 = parkingLot.allocateParking(new Vehicle(VehicleType.BIKE, "TS03AE33142"));
            Thread.sleep(Long.parseLong("1000"));
            ParkingTicket parkingTicket4 = parkingLot.allocateParking(new Vehicle(VehicleType.TRUCK, "AP39Z1441"));
            Thread.sleep(Long.parseLong("10000"));
            parkingLot.deAllocateParking(parkingTicket3, new CreditCardPayment());
            Thread.sleep(Long.parseLong("10000"));
            parkingLot.deAllocateParking(parkingTicket2, new CashPayment());
            Thread.sleep(Long.parseLong("10000"));
            parkingLot.deAllocateParking(parkingTicket4, new CashPayment());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    static void addParkingSpots(ParkingLot parkingLot){
        parkingLot.addSpot(new ParkingSpot("1", "Ground", VehicleType.BIKE,false));
        parkingLot.addSpot(new ParkingSpot("2", "Ground", VehicleType.CAR,false));
        parkingLot.addSpot(new ParkingSpot("3", "Ground", VehicleType.TRUCK,false));
        parkingLot.addSpot(new ParkingSpot("1", "1st-floor", VehicleType.BIKE,false));
        parkingLot.addSpot(new ParkingSpot("2", "1st-floor", VehicleType.CAR,false));
        parkingLot.addSpot(new ParkingSpot("3", "1st-floor", VehicleType.TRUCK,false));
        parkingLot.addSpot(new ParkingSpot("1", "2nd-floor", VehicleType.BIKE,false));
        parkingLot.addSpot(new ParkingSpot("2", "2nd-floor", VehicleType.CAR,false));
        parkingLot.addSpot(new ParkingSpot("3", "2nd-floor", VehicleType.TRUCK,false));

    }

    static void addFees(ParkingLot parkingLot){
        HashMap<VehicleType, Double> feesMap = new HashMap<>();
        feesMap.put(VehicleType.BIKE, 10.00);
        feesMap.put(VehicleType.CAR, 20.00);
        feesMap.put(VehicleType.TRUCK, 25.00);
        parkingLot.setParkingFees(feesMap);

    }
}