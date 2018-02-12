package main;

import observer.SmokeDetector;

public class Floor {
    private String floorName;

    private SmokeDetector smokeDetector;
    private boolean isOnFire;
    private Building building;


    public Floor(String floorName, Building building) {
        this.floorName = floorName;
        this.isOnFire = false;
        this.building = building;
        }
    public void installSmokeDetector() {
        this.smokeDetector = new SmokeDetector(this);
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public boolean isOnFire() {
        return isOnFire;
    }

    public void setOnFire(boolean onFire) {
        isOnFire = onFire;
        if(onFire) {
            smokeDetector.sendAlarm();
        }
    }

    public SmokeDetector getSmokeDetector() {
        return smokeDetector;
    }

    public Building getBuilding() {
        return building;
    }
}
