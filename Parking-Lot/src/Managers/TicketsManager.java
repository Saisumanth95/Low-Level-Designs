package Managers;

import Models.ParkingSpot;
import Models.ParkingTicket;
import Models.Vehicle;

import java.time.Instant;
import java.util.UUID;

public class TicketsManager {

    public ParkingTicket generateTicket(ParkingSpot parkingSpot, Vehicle vehicle){
        ParkingTicket parkingTicket = new ParkingTicket(UUID.randomUUID().toString(), parkingSpot, Instant.now(), vehicle);
        return parkingTicket;
    }

}
