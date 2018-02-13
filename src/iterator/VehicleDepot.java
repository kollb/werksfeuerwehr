package iterator;

import main.NormalFireTruck;
import main.SpecialFireTruck;

import java.util.ArrayList;
import java.util.Collections;


public class VehicleDepot implements IAggregate {

    private ArrayList<NormalFireTruck> normalFireTrucks = new ArrayList<>();
    private ArrayList<SpecialFireTruck> specialFireTrucks = new ArrayList<>();
    private int numberNormalTrucks = 4;
    private int numberSpecialTrucks = 2;
    private int maxNormalTrucks = 4;
    private int maxSpecialTrucks = 2;
    private int depotNumber;

    public VehicleDepot(int depotNumber) {
        for (int i = 0; i < maxNormalTrucks; i++) normalFireTrucks.add(new NormalFireTruck(true, depotNumber));
        for (int i = 0; i < maxSpecialTrucks; i++) specialFireTrucks.add(new SpecialFireTruck(true, depotNumber));

    }

    public NormalFireTruck getNormalFireTruck() {
        NormalFireTruck temp = normalFireTrucks.get(numberNormalTrucks - 1);
        normalFireTrucks.remove(numberNormalTrucks - 1);
        numberNormalTrucks--;
        return temp;
    }

    public SpecialFireTruck getSpecialFireTruck() {
        SpecialFireTruck temp = specialFireTrucks.get(numberSpecialTrucks - 1);
        normalFireTrucks.remove(numberSpecialTrucks - 1);
        numberSpecialTrucks--;
        return temp;
    }

    public void returnVehicle(NormalFireTruck fireTruck) {
        normalFireTrucks.add(fireTruck);
        numberNormalTrucks++;
    }

    public void returnVehicle(SpecialFireTruck fireTruck) {
        specialFireTrucks.add(fireTruck);
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

    public ArrayList<NormalFireTruck> getNormalFireTrucks() {
        return normalFireTrucks;
    }

    public ArrayList<SpecialFireTruck> getSpecialFireTrucks() {
        return specialFireTrucks;
    }

}
