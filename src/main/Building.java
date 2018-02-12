package main;

public class Building {

    private Floor floor1, floor2, floor3;
    private int buildingId;
    private String buildingName;
    private int hazardClass;

    public Building(String buildingName, int buildingId, int hazardClass) {
        this.floor1 = new Floor("Floor 1");
        this.floor2 = new Floor("Floor 2");
        this.floor3 = new Floor("Floor 3");
        this.buildingName = buildingName;
        this.buildingId = buildingId;
        this.hazardClass = hazardClass;
    }

    public int getHazardClass() {
        return hazardClass;
    }

    public void setHazardClass(int hazardClass) {
        this.hazardClass = hazardClass;
    }

    public Floor getFloor1() {
        return floor1;
    }

    public void setFloor1(Floor floor1) {
        this.floor1 = floor1;
    }

    public Floor getFloor2() {
        return floor2;
    }

    public void setFloor2(Floor floor2) {
        this.floor2 = floor2;
    }

    public Floor getFloor3() {
        return floor3;
    }

    public void setFloor3(Floor floor3) {
        this.floor3 = floor3;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }


}
