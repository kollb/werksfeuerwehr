package mediator;

import iterator.VehicleDepot;
import iterator.VehicleIterator;
import main.Building;
import main.Floor;

import java.util.HashMap;

public class CentralFireDepartment implements ICentralFireDepartment {

    HashMap<Integer, Integer> floorAlarmListAll = new HashMap<>();
    VehicleDepot VD1 = new VehicleDepot(1);
    VehicleDepot VD2 = new VehicleDepot(2);

    VehicleIterator vehicleIterator1 = new VehicleIterator(VD1);
    VehicleIterator vehicleIterator2 = new VehicleIterator(VD2);

    @Override
    public void registerTrucks(Floor floor) {
        // Hazard Class 1 + Etage 1+ Etage 2
        if (floor.getBuilding().getBuildingId() <= 3 && floor.getBuilding().getHazardClass() < 2 && floorAlarmListAll.get(floor.getBuilding().getBuildingId()) < 2) {
            for (int i = 0; i < floorAlarmListAll.get(floor.getBuilding().getBuildingId()); i++) {
                if (vehicleIterator1.hasNextNormalFireTruck()) {
                    System.out.println("Normaler Truck ist unterwegs");
                    VD1.getNormalFireTruck().setAvailability(false);
                }else {
                    System.out.println("Kein Normaler da Sende von Depot 2");
                }
            }
        }
    // Hazard Class 1 + Etage 3
        if (floor.getBuilding().getBuildingId() <= 3 && floor.getBuilding().getHazardClass() < 2 && floorAlarmListAll.get(floor.getBuilding().getBuildingId()) < 3) {
            for (int i = 0; i < floorAlarmListAll.get(floor.getBuilding().getBuildingId()); i++) {
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


        // Hazard Class 2 + Etage 1
        if (floor.getBuilding().getBuildingId() > 3 && floor.getBuilding().getHazardClass() >= 2) {

            if (vehicleIterator1.hasNextNormalFireTruck()) {
                System.out.println("Special Truck ist unterwegs");
                VD1.getNormalFireTruck().setAvailability(false);
            } else {
                System.out.println("Kein Normaler da Sende von Depot 1");
            }
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
        registerTrucks(floor);
    }

    public void print() {
        System.out.println(floorAlarmListAll.toString());
    }

}
