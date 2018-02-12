package main;


import mediator.CentralFireDepartment;
import observer.ISmokeDetectorListener;

import java.util.ArrayList;
import java.util.HashMap;

public class FireDepartment  implements ISmokeDetectorListener{
    CentralFireDepartment command;

    public FireDepartment(CentralFireDepartment command) {
        this.command = command;
    }

    @Override
    public void fireIgnited(Floor location) {
        System.out.println("Building "+ location.getBuilding().getBuildingName()+ " on "+location.getFloorName()+ " is on fire!");
        command.getAlarm(location);
    }
}