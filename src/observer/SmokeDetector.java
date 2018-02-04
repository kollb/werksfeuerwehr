package observer;

import java.util.ArrayList;

public class SmokeDetector {
    private ArrayList<ISmokeDetectorListener> listeners;
    public SmokeDetector() {
        listeners = new ArrayList<>();
    }
    public void sendAlarm() {
        for (ISmokeDetectorListener listener: listeners)
            listener.fireIgnited("SmokeDetector");
    }
    public void addListener(ISmokeDetectorListener listener) {
        listeners.add(listener);
    }
    public void removeListener(ISmokeDetectorListener listener) {
        listeners.remove(listener);
    }
}