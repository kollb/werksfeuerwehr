package iterator;

import main.FireTruck;
import main.NormalFireTruck;
import main.SpecialFireTruck;

import java.util.HashSet;

public class VehicleDepot implements IAggregate {
    private NormalFireTruck[] normalFireTrucks;
    private SpecialFireTruck[] specialFireTrucks;
    private int numberNormalTrucks = 4;
    private int numberSpecialTrucks = 2;
    private int maxNormalTrucks=4;
    private int maxSpecialTrucks=2;

    public VehicleDepot(int numberNormalTrucks, int numberSpecialTrucks) {
        normalFireTrucks = new NormalFireTruck[maxNormalTrucks];
        specialFireTrucks = new SpecialFireTruck[maxSpecialTrucks];
    }

    public NormalFireTruck getNormalFireTruck(){
        return normalFireTrucks[maxNormalTrucks-1];
    }

    public SpecialFireTruck getSpecialFireTruck(){
        return specialFireTrucks[maxSpecialTrucks-1];
    }

    public void returnVehicle(NormalFireTruck fireTruck){
        normalFireTrucks[numberNormalTrucks]=fireTruck;
        numberNormalTrucks++;
    }

    public void returnVehicle(SpecialFireTruck fireTruck){
        specialFireTrucks[numberSpecialTrucks]=fireTruck;
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
