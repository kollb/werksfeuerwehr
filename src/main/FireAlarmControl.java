package main;

import java.util.HashMap;

public class FireAlarmControl {
    private Building building;


    public FireAlarmControl(Building building) {
        this.building = building;
    }

    private HashMap<Integer,Integer> generateFloorAlarmList(){
        HashMap<Integer,Integer> floorAlarmList = new HashMap<>();
        if (this.building.getFloor1().isOnFire()) floorAlarmList.put(this.building.getBuildingId(),1);
        if (this.building.getFloor2().isOnFire()) floorAlarmList.put(this.building.getBuildingId(),2);
        if (this.building.getFloor3().isOnFire()) floorAlarmList.put(this.building.getBuildingId(),3);
        return floorAlarmList;
    }

    public HashMap<Integer,Integer> sendAlarmList(){
        HashMap<Integer,Integer> list = generateFloorAlarmList();
        return list;
    }
}
