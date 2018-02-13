package iterator;

import main.NormalFireTruck;
import main.SpecialFireTruck;

public class VehicleIterator implements IIterator {

    private VehicleDepot vehicleDepot;
    private int indexNormalFireTruck;
    private int indexSpecialFireTruck;

    public VehicleIterator(VehicleDepot vehicleDepot) {
        this.vehicleDepot = vehicleDepot;
        this.indexNormalFireTruck = 0;
        this.indexSpecialFireTruck = 0;
    }

    public boolean hasNextNormalFireTruck() {
        return indexNormalFireTruck < vehicleDepot.getNumberNormalTrucks();
    }

    public boolean hasNextSpecialFireTruck() {
        return indexSpecialFireTruck < vehicleDepot.getNumberSpecialTrucks();
    }

    public Object nextNormalFiretruck() {
        Object normalFireTruck = vehicleDepot.getNormalFireTruck();
        indexNormalFireTruck++;
        return normalFireTruck;
    }

    public Object nextSpecialFiretruck() {
        Object specialFireTruck = vehicleDepot.getSpecialFireTruck();
        indexSpecialFireTruck++;
        return specialFireTruck;
    }
}
