package mediator;

import iterator.VehicleDepot;
import iterator.VehicleIterator;
import main.Floor;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CentralFireDepartment implements ICentralFireDepartment {

    HashMap<Integer, Integer> floorAlarmListAll = new HashMap<>();
    VehicleDepot VD1 = new VehicleDepot(1);
    VehicleDepot VD2 = new VehicleDepot(2);

    VehicleIterator vehicleIterator1 = new VehicleIterator(VD1);
    VehicleIterator vehicleIterator2 = new VehicleIterator(VD2);

    @Override
    public void registerTrucks(Floor floor) {
        //TODO Building3 Hazard Class 1

        //VehicleDepot VD1
        // Hazard Class 1 + Etage 1+ Etage 2
        if (floor.getBuilding().getBuildingId() <= 3 && floor.getBuilding().getHazardClass() >1 && floorAlarmListAll.get(floor.getBuilding().getBuildingId()) <= 2) {
            for (int i = 0; i < floorAlarmListAll.get(floor.getBuilding().getBuildingId())+1; i++) {
                if (vehicleIterator1.hasNextNormalFireTruck()) {
                    System.out.println("Normaler Truck ist unterwegs");
                    VD1.getNormalFireTruck().setAvailability(false);
                }else {
                    System.out.println("Kein Normaler da Sende von Depot 2");
                }
            }
        } else
            // Hazard Class 1 + Etage 3
            if (floor.getBuilding().getBuildingId() <= 3 && floor.getBuilding().getHazardClass() > 1 && floorAlarmListAll.get(floor.getBuilding().getBuildingId()) >= 2) {
                for (int i = 0; i < floorAlarmListAll.get(floor.getBuilding().getBuildingId())+1; i++) {
                    if (vehicleIterator2.hasNextNormalFireTruck()) {
                        System.out.println("Normaler Truck ist unterwegs");
                        VD1.getNormalFireTruck().setAvailability(false);
                    }else {
                        System.out.println("Kein Normaler da Sende von Depot 2");
                    }
                }
                if (vehicleIterator2.hasNextSpecialFireTruck()) {
                    System.out.println("Special Truck ist unterwegs");
                }else {
                    System.out.println("Kein Normaler da Sende von Depot 2");
                }
            }
        else
        //VehicleDepot VD2
        // Hazard Class 2 + Etage 1
        if (floor.getBuilding().getBuildingId() > 3 && floor.getBuilding().getHazardClass() >= 2) {

            if (vehicleIterator1.hasNextNormalFireTruck()) {
                System.out.println("Special Truck ist unterwegs");
                VD1.getNormalFireTruck().setAvailability(false);
            } else {
                System.out.println("Kein Normaler da Sende von Depot 1");
            }
        } else {
            System.out.println("--- Nothing -  Building"+floor.getBuilding().getBuildingId()+" Hazard Class "+floor.getBuilding().getHazardClass()+ " Floor "+floor.getId());
        }

    }


    public void getAlarm(Floor floor) {
        int i = 0;
        if (!floorAlarmListAll.isEmpty() && floorAlarmListAll.get(floor.getBuilding().getBuildingId()) != null) {
            i = floorAlarmListAll.get(floor.getBuilding().getBuildingId());
        }
        floorAlarmListAll.put(floor.getBuilding().getBuildingId(), i + 1);
        requestTruck(floor);
    }

    public void requestTruck(Floor floor) {
        try {
            registerTrucks(floor);
            Thread.sleep(1); //TODO change to 1 sec
            System.out.println(VD1.getNormalFireTrucks().toString());
            System.out.println(VD1.getSpecialFireTrucks().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print()  {
        System.out.println(floorAlarmListAll.toString());

    }

}
