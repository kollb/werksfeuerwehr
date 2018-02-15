package test;

import iterator.VehicleDepot;
import iterator.VehicleIterator;
import org.junit.Assert;
import org.junit.Test;

public class IteratorTest {
    @Test
    public void testVehicleDepot(){
        VehicleDepot VD1 = new VehicleDepot(1);
        Assert.assertEquals(4,VD1.getNumberNormalTrucks());
        Assert.assertEquals(2,VD1.getNumberSpecialTrucks());
    }

}
