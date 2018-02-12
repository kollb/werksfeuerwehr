package main;


import observer.ISmokeDetectorListener;

import java.util.ArrayList;
import java.util.HashMap;

public class FireDepartment  implements ISmokeDetectorListener{


    @Override
    public void fireIgnited(Floor location) {
        System.out.println("Building "+ location.getBuilding().getBuildingName()+ " on "+location.getFloorName()+ " is on fire!");
    }

    public void fireIgnited(String location){
        turnOut(location);
    }

    public void turnOut(String location){
        System.out.println("turned out : " + location);
    }
}