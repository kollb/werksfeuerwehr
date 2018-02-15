package test;

import iterator.VehicleDepot;
import main.Building;
import main.FireDepartment;
import mediator.CentralFireDepartment;
import org.junit.Assert;
import org.junit.Test;

public class MediatorTest {

    @Test
    public void testMediator(){
        Building B1 = new Building("B1", 1, 2);
        VehicleDepot VD1 = new VehicleDepot(1);
        CentralFireDepartment CFD = new CentralFireDepartment();
        FireDepartment F1 = new FireDepartment(CFD);
        B1.registerFireDep(F1);
        B1.randomFire();
        // Trucks are coming back
        Assert.assertEquals(4,VD1.getNumberNormalTrucks());
        Assert.assertEquals(2,VD1.getNumberSpecialTrucks());    }
}
