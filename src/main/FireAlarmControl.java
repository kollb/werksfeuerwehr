package main;

import observer.ISmokeDetectorListener;

import java.util.ArrayList;
import java.util.HashMap;

public class FireAlarmControl implements ISmokeDetectorListener {
    private ArrayList<ISmokeDetectorListener> listeners = new ArrayList<>();


    public FireAlarmControl() {
    }

    private HashMap<Integer,Integer> generateFloorAlarmList(Building building){
        HashMap<Integer,Integer> floorAlarmList = new HashMap<>();
        if (building.getFloor1().isOnFire()) floorAlarmList.put(building.getBuildingId(),1);
        if (building.getFloor2().isOnFire()) floorAlarmList.put(building.getBuildingId(),2);
        if (building.getFloor3().isOnFire()) floorAlarmList.put(building.getBuildingId(),3);
        return floorAlarmList;
    }

    public HashMap<Integer,Integer> sendAlarmList(Building building){
        HashMap<Integer,Integer> list = generateFloorAlarmList(building);
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
