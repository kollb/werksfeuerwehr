package iterator;

import main.NormalFireTruck;
import main.SpecialFireTruck;

import java.util.ArrayList;
import java.util.Collections;


public class VehicleDepot implements IAggregate {

    private ArrayList<Object> normalFireTrucks = new ArrayList<>();
    private ArrayList<Object> specialFireTrucks = new ArrayList<>();
    private int numberNormalTrucks = 4;

    private int numberSpecialTrucks = 2;
    private int maxNormalTrucks = 4;
    private int maxSpecialTrucks = 2;
    private int depotNumber;

    public VehicleDepot(int depotNumber) {
        for (int i = 0; i < maxNormalTrucks; i++) normalFireTrucks.add(new NormalFireTruck(true, depotNumber));
        for (int i = 0; i < maxSpecialTrucks; i++) specialFireTrucks.add(new SpecialFireTruck(true, depotNumber));
    }

    public Object getNormalFireTruck() {
        Object temp = normalFireTrucks.get(numberNormalTrucks - 1);
        normalFireTrucks.remove(numberNormalTrucks - 1);
        numberNormalTrucks--;
        return temp;
    }

    public Object getSpecialFireTruck() {
        Object temp = specialFireTrucks.get(numberSpecialTrucks - 1);
        specialFireTrucks.remove(numberSpecialTrucks - 1);
        numberSpecialTrucks--;
        return temp;
    }

    public int getNumberSpecialTrucks() {
        return numberSpecialTrucks;
    }

    public void returnVehicle(Object fireTruck) {
        if (fireTruck instanceof NormalFireTruck) {
            normalFireTrucks.add(fireTruck);
            numberNormalTrucks++;
        }
        if (fireTruck instanceof SpecialFireTruck) {
            specialFireTrucks.add(fireTruck);
            numberSpecialTrucks++;
        }
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

    public ArrayList<Object> getNormalFireTrucks() {
        return normalFireTrucks;
    }

    public ArrayList<Object> getSpecialFireTrucks() {
        return specialFireTrucks;
    }

}
