package main;

import mediator.CentralFireDepartment;
import observer.SmokeDetector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {


    public static void main(String... args) {

        // Create Buildings and "Brandmeldezentrale" BMZ
        Building B1 = new Building("B1",1,2);
        Building B2 = new Building("B2",2,3);
        Building B3 = new Building("B3",3,1);
        Building B4 = new Building("B4",4,2);
        Building B5 = new Building("B5",5,2);
        Building B6 = new Building("B6",6,3);


        CentralFireDepartment CFD = new CentralFireDepartment();
        FireDepartment F1 = new FireDepartment(CFD);
        FireDepartment F2 = new FireDepartment(CFD);

        B1.registerFireDep(F1);
        B2.registerFireDep(F1);
        B3.registerFireDep(F1);
        B4.registerFireDep(F2);
        B5.registerFireDep(F2);
        B6.registerFireDep(F2);

        //create Random Fire Alerts
        List<Building> buildings = new ArrayList<>();
        buildings.add(B1);
        buildings.add(B2);
        buildings.add(B3);
        buildings.add(B4);
        buildings.add(B5);
        buildings.add(B6);
        Collections.shuffle(buildings);
        for (Building building: buildings.subList(0,2)){
            building.randomFire();
        }

        CFD.print();

    }
}
