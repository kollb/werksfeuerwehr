package mediator;

import iterator.VehicleDepot;
import iterator.VehicleIterator;
import main.Floor;
import main.NormalFireTruck;
import main.SpecialFireTruck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CentralFireDepartment implements ICentralFireDepartment {

    HashMap<Integer, Integer> floorAlarmListAll = new HashMap<>();
    VehicleDepot VD1 = new VehicleDepot(1);
    VehicleDepot VD2 = new VehicleDepot(2);

    VehicleIterator vehicleIterator1 = new VehicleIterator(VD1);
    VehicleIterator vehicleIterator2 = new VehicleIterator(VD2);


    @Override
    public synchronized List<Object> registerTrucks(Floor floor) {
        List<Object> missionList = new ArrayList<>();

        if (!vehicleIterator1.hasNextNormalFireTruck() && !vehicleIterator1.hasNextSpecialFireTruck() && !vehicleIterator2.hasNextNormalFireTruck() && !vehicleIterator2.hasNextSpecialFireTruck()) {
            System.out.println(" Black Alert !!!!");
            System.exit(0);
        }
        //VehicleDepot VD1
        // Hazard Class 1 + Etage 1+ Etage 2
        if (floor.getBuilding().getBuildingId() <= 3 && floor.getBuilding().getHazardClass() == 1 && floor.getId() <= 2) {
            for (int i = 0; i < floor.getId(); i++) {
                if (vehicleIterator1.hasNextNormalFireTruck()) {
                    System.out.println("Normal Truck from Depot 1 is on its way to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                    missionList.add(VD1.getNormalFireTruck());
                } else {
                    if (vehicleIterator2.hasNextNormalFireTruck()) {
                        missionList.add(VD2.getNormalFireTruck());
                        System.out.println("No Normal Truck from Depot 1 available. Sending one from Depot 2 to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                    } else {
                        System.out.println("!!! Black Alert !!!");
                    }
                }
            }
        }
        //Hazard Class 1 + Etage 3
        else if (floor.getBuilding().getBuildingId() <= 3 && floor.getBuilding().getHazardClass() == 1 && floor.getId() == 3) {
            for (int i = 0; i < floor.getId(); i++) {
                if (vehicleIterator1.hasNextNormalFireTruck()) {
                    System.out.println("Normal Truck from Depot 1 is on its way to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                    missionList.add(VD1.getNormalFireTruck());
                } else {
                    if (vehicleIterator2.hasNextNormalFireTruck()) {
                        missionList.add(VD2.getNormalFireTruck());
                        System.out.println("No Normal Truck from Depot 1 available. Sending one from Depot 2 to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                    } else {
                        System.out.println("!!! Black Alert !!!");
                    }
                }
            }
            if (vehicleIterator1.hasNextSpecialFireTruck()) {
                System.out.println("Special Truck from Depot 1 is on its way to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                missionList.add(VD1.getSpecialFireTruck());
            } else {
                if (vehicleIterator2.hasNextSpecialFireTruck()) {
                    System.out.println("No Special Truck from Depot 1 available. Sending one from Depot 2 to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                    missionList.add(VD2.getSpecialFireTruck());
                } else {
                    System.out.println("!!! Black Alert !!!");
                }

            }
        } else
            //Hazard Class 2 + Etage 1 + Etage 2
            if (floor.getBuilding().getBuildingId() <= 3 && floor.getBuilding().getHazardClass() > 1 && floor.getId() <= 2) {
                for (int i = 0; i < floor.getId() + 1; i++) {
                    if (vehicleIterator1.hasNextNormalFireTruck()) {
                        System.out.println("Normal Truck from Depot 1 is on its way to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                        Object truck = VD1.getNormalFireTruck();
                        ((NormalFireTruck) truck).setAvailability(false);
                        missionList.add(truck);
                    } else {
                        if (vehicleIterator2.hasNextNormalFireTruck()) {
                            Object truck = VD2.getNormalFireTruck();
                            ((NormalFireTruck) truck).setAvailability(false);
                            missionList.add(truck);
                            System.out.println("No Normal Truck from Depot 1 available. Sending one from Depot 2 to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                        } else {
                            System.out.println("!!! Black Alert !!!");
                        }
                    }
                }
                if (vehicleIterator1.hasNextSpecialFireTruck()) {
                    System.out.println("Special Truck from Depot 1 is on its way to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                    Object truck = VD1.getSpecialFireTruck();
                    ((SpecialFireTruck) truck).setAvailability(false);
                    missionList.add(truck);
                } else {
                    if (vehicleIterator2.hasNextSpecialFireTruck()) {
                        System.out.println("No Special Truck from Depot 1 available. Sending one from Depot 2 to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                        Object truck = VD2.getSpecialFireTruck();
                        ((SpecialFireTruck) truck).setAvailability(false);
                        missionList.add(truck);
                    } else {
                        System.out.println("!!! Black Alert !!!");
                    }
                }
            } else
                // Hazard Class 2 + Etage 3
                if (floor.getBuilding().getBuildingId() <= 3 && floor.getBuilding().getHazardClass() > 1 && floor.getId() == 3) {
                    for (int i = 0; i < floor.getId() + 1; i++) {
                        if (vehicleIterator1.hasNextNormalFireTruck()) {
                            System.out.println("Normal Truck from Depot 1 is on its way to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                            Object truck = VD1.getNormalFireTruck();
                            ((NormalFireTruck) truck).setAvailability(false);
                            missionList.add(truck);
                        } else {
                            if (vehicleIterator2.hasNextNormalFireTruck()) {
                                Object truck = VD2.getNormalFireTruck();
                                ((NormalFireTruck) truck).setAvailability(false);
                                missionList.add(truck);
                                System.out.println("No Normal Truck from Depot 1 available. Sending one from Depot 2 to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                            } else {
                                System.out.println("!!! Black Alert !!!");
                            }
                        }
                    }
                    if (vehicleIterator1.hasNextSpecialFireTruck()) {
                        Object truck = VD1.getSpecialFireTruck();
                        ((SpecialFireTruck) truck).setAvailability(false);
                        missionList.add(truck);
                        System.out.println("Special Truck from Depot 1 is on its way to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                    } else {
                        if (vehicleIterator2.hasNextSpecialFireTruck()) {
                            Object truck = VD2.getSpecialFireTruck();
                            ((SpecialFireTruck) truck).setAvailability(false);
                            missionList.add(truck);
                            System.out.println("No Special Truck from Depot 1 available. Sending one from Depot 2 to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                        } else {
                            System.out.println("!!! Black Alert !!!");
                        }
                    }
                } else
                    //VehicleDepot VD2
                    // Hazard Class 2 + Etage 1 + Etage 2
                    if (floor.getBuilding().getBuildingId() > 3 && floor.getBuilding().getHazardClass() >= 2 && floor.getId() <= 2) {
                        for (int i = 0; i < floor.getId() + 1; i++) {
                            if (vehicleIterator2.hasNextNormalFireTruck()) {
                                System.out.println("Normal Truck from Depot 2 is on its way to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                                Object truck = VD2.getNormalFireTruck();
                                ((NormalFireTruck) truck).setAvailability(false);
                                missionList.add(truck);
                            } else {
                                if (vehicleIterator1.hasNextNormalFireTruck()) {
                                    System.out.println("No Normal Truck from Depot 2 available. Sending one from Depot 1 to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                                    Object truck = VD1.getNormalFireTruck();
                                    ((NormalFireTruck) truck).setAvailability(false);
                                    missionList.add(truck);
                                } else {
                                    System.out.println("!!! Black Alert !!!");
                                }
                            }
                        }
                        if (vehicleIterator2.hasNextSpecialFireTruck()) {
                            System.out.println("Special Truck from Depot 2 is on its way to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                            Object truck = VD2.getSpecialFireTruck();
                            ((SpecialFireTruck) truck).setAvailability(false);
                            missionList.add(truck);
                        } else {
                            if (vehicleIterator1.hasNextSpecialFireTruck()) {
                                System.out.println("No Special Truck from Depot 2 available. Sending one from Depot 1 to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                                Object truck = VD1.getSpecialFireTruck();
                                ((SpecialFireTruck) truck).setAvailability(false);
                                missionList.add(truck);
                            } else {
                                System.out.println("!!! Black Alert !!!");
                            }
                        }
                    } else
                        // Hazard Class 2 + Etage 3
                        if (floor.getBuilding().getBuildingId() > 3 && floor.getId() == 3) {
                            for (int i = 0; i < floor.getId() + 1; i++) {
                                if (vehicleIterator2.hasNextNormalFireTruck()) {
                                    System.out.println("Normal Truck from Depot 2 is on its way to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                                    Object truck = VD2.getNormalFireTruck();
                                    ((NormalFireTruck) truck).setAvailability(false);
                                    missionList.add(truck);
                                } else {
                                    if (vehicleIterator1.hasNextNormalFireTruck()) {
                                        System.out.println("No Normal Truck from Depot 2 available. Sending one from Depot 1 to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                                        Object truck = VD1.getNormalFireTruck();
                                        ((NormalFireTruck) truck).setAvailability(false);
                                        missionList.add(truck);
                                    } else {
                                        System.out.println("!!! Black Alert !!!");
                                    }
                                }
                            }
                            for (int i = 0; i < 2; i++) {
                                if (vehicleIterator2.hasNextSpecialFireTruck()) {
                                    System.out.println("Special Truck from Depot 2 is on its way to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                                    Object truck = VD2.getSpecialFireTruck();
                                    ((SpecialFireTruck) truck).setAvailability(false);
                                    missionList.add(truck);
                                } else {
                                    if (vehicleIterator1.hasNextSpecialFireTruck()) {
                                        System.out.println("No Special Truck from Depot 2 available. Sending one from Depot 1 to Building " + floor.getBuilding().getBuildingId() + " Floor " + floor.getId());
                                        Object truck = VD1.getSpecialFireTruck();
                                        ((SpecialFireTruck) truck).setAvailability(false);
                                        missionList.add(truck);
                                    } else {
                                        System.out.println("!!! Black Alert !!!");
                                    }
                                }
                            }
                        } else {
                            System.out.println("--- Nothing -  Building " + floor.getBuilding().getBuildingId() + " Hazard Class " + floor.getBuilding().getHazardClass() + " Floor " + floor.getId());
                        }
        return missionList;
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
        List<Object> onMission = registerTrucks(floor);
        System.out.println(" Depot 1 --- NormalTrucks Size : " + VD1.getNormalFireTrucks().size() + " SpecialTruck Size : " + VD1.getSpecialFireTrucks().size());
        System.out.println(" Depot 2 --- NormalTrucks Size : " + VD2.getNormalFireTrucks().size() + " SpecialTruck Size : " + VD2.getSpecialFireTrucks().size());
        System.out.println(" On Mission --- Size : " + onMission.size());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        returnFromMission(onMission);
        System.out.println("---! Returning from Mission !---");
    }

    synchronized void returnFromMission(List<Object> onMission) {
        //System.out.println("---- Return ----");
        int size = onMission.size();
        for (int i = 0; i < size; i++) {
            Object temp = onMission.get(0);
            onMission.remove(0);
            if (temp instanceof NormalFireTruck) {
                ((NormalFireTruck) temp).setAvailability(true);
                if (((NormalFireTruck) temp).getDepotReference() == 1) VD1.returnVehicle(temp);
                if (((NormalFireTruck) temp).getDepotReference() == 2) VD2.returnVehicle(temp);
            }
            if (temp instanceof SpecialFireTruck) {
                ((SpecialFireTruck) temp).setAvailability(true);
                if (((SpecialFireTruck) temp).getDepotReference() == 1) VD1.returnVehicle(temp);
                if (((SpecialFireTruck) temp).getDepotReference() == 2) VD2.returnVehicle(temp);
            }
        }
        //System.out.println(" Depot 1 --- NormalTrucks Size : " + VD1.getNormalFireTrucks().size() + " SpecialTruck Size : " + VD1.getSpecialFireTrucks().size());
        //System.out.println(" Depot 2 --- NormalTrucks Size : " + VD2.getNormalFireTrucks().size() + " SpecialTruck Size : " + VD2.getSpecialFireTrucks().size());
        //System.out.println("---- Return ----");

    }
}
