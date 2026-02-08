package ParkingLot;

import Managers.ParkingFeeManager;
import Managers.ParkingSpotsManager;
import Managers.PaymentsManager;
import Managers.TicketsManager;
import Models.ParkingSpot;
import Models.ParkingTicket;
import Models.Vehicle;
import Models.VehicleType;
import Payments.PaymentStrategy;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private static ParkingLot parkingLot = null;
    private ParkingSpotsManager parkingSpotsManager;
    private TicketsManager ticketsManager;
    private PaymentsManager paymentsManager;
    private ParkingFeeManager parkingFeeManager;

    private ParkingLot(){
        parkingSpotsManager = new ParkingSpotsManager();
        ticketsManager = new TicketsManager();
        parkingFeeManager = new ParkingFeeManager();
    }

    public static ParkingLot getInstance(){
        if(parkingLot ==  null){
            synchronized (ParkingLot.class){
                if(parkingLot == null){
                    parkingLot = new ParkingLot();
                }
            }
        }
        return parkingLot;
    }

    public void addSpot(ParkingSpot parkingSpot) {
        this.parkingSpotsManager.addParkingSpots(parkingSpot);
    }

    public void setParkingFees(Map<VehicleType, Double> vehicleTypeDoubleMap){
        parkingFeeManager.setVehicleCharges(vehicleTypeDoubleMap);
    }

    public ParkingTicket allocateParking(Vehicle vehicle) throws Exception{
        ParkingSpot parkingSpot = parkingSpotsManager.parkVehicle(vehicle);
        ParkingTicket parkingTicket;
        if(parkingSpot != null){
            parkingTicket = ticketsManager.generateTicket(parkingSpot, vehicle);
            System.out.println("Allocated Parking for vehicle : " + vehicle.getVehicleNumber() + " : " + vehicle.getVehicleType() + " in " + parkingSpot.getFloorNumber() + " and slot no : " + parkingSpot.getSlotNumber() + "\n");
        }else{
            throw new Exception("No parking spots available");
        }
        return parkingTicket;
    }

    public void deAllocateParking(ParkingTicket parkingTicket, PaymentStrategy paymentStrategy){
        ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
        parkingSpotsManager.unParkVehicle(parkingSpot);
        double amount = parkingFeeManager.generateFees(parkingTicket.getVehicle().getVehicleType(), parkingTicket.getEntryTime(), Instant.now());
        paymentsManager = new PaymentsManager(paymentStrategy);
        paymentsManager.chargeAmount(amount);
        System.out.println("Successfully de-allocated Parking for vehicle : " + parkingTicket.getVehicle().getVehicleNumber() + " : " + parkingTicket.getVehicle().getVehicleType()+"\n");
    }




}
