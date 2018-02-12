package observer;

import main.Floor;

import java.util.HashMap;

public interface ISmokeDetectorListener {

    //getNotified#
    void fireIgnited(Floor location);
}
