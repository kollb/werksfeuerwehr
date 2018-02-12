package iterator;

import main.NormalFireTruck;
import main.SpecialFireTruck;


public class VehicleDepot implements IAggregate {
    private NormalFireTruck[] normalFireTrucks;
    private SpecialFireTruck[] specialFireTrucks;
    private int numberNormalTrucks = 4;
    private int numberSpecialTrucks = 2;
    final int maxNormalTrucks = 4;
    final int maxSpecialTrucks = 2;
    private int depotNumber;

    public VehicleDepot(int depotNumber) {
        normalFireTrucks = new NormalFireTruck[maxNormalTrucks];
        for (NormalFireTruck normal : normalFireTrucks) normal.setDepotReference(depotNumber);
        specialFireTrucks = new SpecialFireTruck[maxSpecialTrucks];
        for (SpecialFireTruck special : specialFireTrucks) special.setDepotReference(depotNumber);
    }

    public NormalFireTruck getNormalFireTruck() {
        return normalFireTrucks[maxNormalTrucks - 1];
    }

    public SpecialFireTruck getSpecialFireTruck() {
        return specialFireTrucks[maxSpecialTrucks - 1];
    }

    public void returnVehicle(NormalFireTruck fireTruck) {
        normalFireTrucks[numberNormalTrucks] = fireTruck;
        numberNormalTrucks++;
    }

    public void returnVehicle(SpecialFireTruck fireTruck) {
        specialFireTrucks[numberSpecialTrucks] = fireTruck;
        numberSpecialTrucks++;
    }


    public int getMaxNormalTrucks() {
        return maxNormalTrucks;
    }

    public int getNumberNormalTrucks() {
        return numberNormalTrucks;
    }

    public IIterator iterator() {
        return new VehicleIterator(this);
    }
}
