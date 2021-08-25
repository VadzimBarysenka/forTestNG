package shop;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

public class RealItemTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeMethod(groups = {"Test"})
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterMethod(groups = {"Test"})
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test(groups = {"Test"})
    void testToString() {
        RealItem car = new RealItem();
        car.setName("REAL_ITEM_NAME");
        car.setPrice(3);
        car.setWeight(5);

        System.out.print(car);
        assertEquals("Class: " + car.getClass() + "; " + "Name: " + car.getName() + "; " + "Price: " + car.getPrice() + "; " + "Weight: " + car.getWeight(), outContent.toString());
    }
}