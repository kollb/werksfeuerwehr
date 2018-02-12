package main;

import observer.ISmokeDetectorListener;


public class Floor {
    private ISmokeDetectorListener smokeDetector;
    private String floorName;

    private boolean isOnFire;


    public Floor(String floorName) {
        this.smokeDetector = location -> {
        };
        this.floorName = floorName;
        this.isOnFire = false;
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
    }

}
