package Models;

import java.time.Instant;

public class ParkingTicket {
    private String ticketId;
    private ParkingSpot parkingSpot;
    private Instant entryTime;
    private Vehicle vehicle;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingTicket(String ticketId, ParkingSpot parkingSpot, Instant entryTime, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
    }
}
