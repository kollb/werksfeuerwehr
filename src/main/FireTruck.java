package main;

public abstract class FireTruck{
    private boolean availability;
    private int depotReference;

    public void setDepotReference(int depotReference) {
        this.depotReference = depotReference;
    }

    public boolean isAvavailable() {
        return availability;
    }

    public void setAvailability(boolean avail){
        this.availability= avail;
    }
}
