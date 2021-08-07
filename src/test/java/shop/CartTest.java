package shop;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest {
    private static final String CART_NAME = RandomStringUtils.randomAlphabetic(10);
    private static final String REAL_ITEM_NAME = "KASHKAI";
    private static final double REAL_ITEM_PRICE = 1000.0;
    private static final double REAL_ITEM_WEIGHT = 1420;
    private static final String VIRTUAL_ITEM_NAME = "OpenSUSE";
    private static final double VIRTUAL_ITEM_PRICE = 0.1;
    private static final double VIRTUAL_ITEM_SIZE_ON_DISK = 40000;
    private static final double TAX = 0.2;
    Cart testCart = null;
    RealItem car = null;
    VirtualItem disk = null;

    @Test(groups = {"Test"})
    @BeforeMethod
    public void setUp() {
        testCart = new Cart(CART_NAME);

        car = new RealItem();
        car.setName(REAL_ITEM_NAME);
        car.setPrice(REAL_ITEM_PRICE);
        car.setWeight(REAL_ITEM_WEIGHT);

        testCart.addRealItem(car);
    }
    @Test(groups = {"Test"})
    @AfterMethod
    public void tearDown() {
    }

    @Test(groups = {"Test2"})
    public void testDeleteRealItem() {

        testCart.deleteRealItem(car);

        assertEquals(testCart.getTotalPrice(), 0.0);
    }

    @Test(groups = {"Test"})
    public void testGetTotalPrice() {

        double  actualTotal = car.getPrice() + car.getPrice()*TAX;

        assertEquals(testCart.getTotalPrice(), actualTotal);
    }
}