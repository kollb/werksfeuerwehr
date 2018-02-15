package main;

import observer.SmokeDetector;

public class Floor {
    private String floorName;

    private SmokeDetector smokeDetector;
    private boolean isOnFire;
    private Building building;
    private int id;

    public Floor(String floorName, Building building, int id) {
        this.floorName = floorName;
        this.isOnFire = false;
        this.building = building;
        this.id = id;
    }

    public void installSmokeDetector() {
        this.smokeDetector = new SmokeDetector(this);
    }

    public String getFloorName() {
        return floorName;
    }


    public boolean isOnFire() {
        return isOnFire;
    }

    public void setOnFire(boolean onFire) {
        isOnFire = onFire;
        if (onFire) {
            smokeDetector.sendAlarm();
        }
    }

    public SmokeDetector getSmokeDetector() {
        return smokeDetector;
    }

    public Building getBuilding() {
        return building;
    }

    public int getId() {
        return id;
    }
}
