package observer;

import main.Floor;

import java.util.ArrayList;

public class SmokeDetector {
    private ArrayList<ISmokeDetectorListener> listeners;
    private Floor floor;

    public SmokeDetector(Floor floor) {
        listeners = new ArrayList<>();
        this.floor = floor;
        this.addListener(floor.getBuilding().getFireAlarmControl());
    }

    public void sendAlarm() {
        for (ISmokeDetectorListener listener : listeners)
            listener.fireIgnited(floor);
    }

    public void addListener(ISmokeDetectorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ISmokeDetectorListener listener) {
        listeners.remove(listener);
    }
}