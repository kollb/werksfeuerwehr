package mediator;

import main.Building;

public class CentralFireDepartment implements ICentralFireDepartment {

    @Override
    public void registerTrucks(Building building) {
        if (building.getBuildingId() <= 3 && building.getHazardClass()<2){

        }
    }

}
