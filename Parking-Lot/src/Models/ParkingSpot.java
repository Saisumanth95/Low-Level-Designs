package Models;

public class ParkingSpot {
    private String slotNumber;
    private String floorNumber;
    private VehicleType vehicleType;
    private boolean isOccupied;

    public ParkingSpot(String slotNumber, String floorNumber, VehicleType vehicleType, boolean isOccupied) {
        this.slotNumber = slotNumber;
        this.floorNumber = floorNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = isOccupied;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
