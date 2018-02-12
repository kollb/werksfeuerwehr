package main;

import observer.ISmokeDetectorListener;

import java.util.ArrayList;
import java.util.HashMap;

public class FireAlarmControl implements ISmokeDetectorListener {
    private Building building;
    private ArrayList<ISmokeDetectorListener> listeners = new ArrayList<>();


    public FireAlarmControl() {

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

    public void addListener(ISmokeDetectorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ISmokeDetectorListener listener) {
        listeners.remove(listener);
    }


    @Override
    public void fireIgnited(Floor location) {
        for (ISmokeDetectorListener listener : listeners)
            listener.fireIgnited(location);
    }

}
