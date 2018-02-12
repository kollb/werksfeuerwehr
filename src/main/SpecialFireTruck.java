package main;

public class SpecialFireTruck {
    private boolean availability;
    private int depotReference;

    public SpecialFireTruck(boolean availability, int depotReference) {
        this.availability = true;
        this.depotReference = depotReference;
    }

    public void setDepotReference(int depotReference) {
        this.depotReference = depotReference;
        this.availability = true;
    }

    public boolean isAvavailable() {
        return availability;
    }

    public void setAvailability(boolean avail) {
        this.availability = avail;
    }

    public int getDepotReference() {
        return depotReference;
    }

}
