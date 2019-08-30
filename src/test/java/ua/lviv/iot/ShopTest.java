package ua.lviv.iot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import ua.lviv.iot.models.Shop;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopTest {

    private List<Integer> listOfPrices = new ArrayList<>();
    private int discount;
    private Shop shop = new Shop();

    private void setUpForOne() {
        try (FileReader fr = new FileReader("test1.in");
             Scanner scanner = new Scanner(fr)) {
            while (scanner.hasNextLine()) {
                listOfPrices.add(scanner.nextInt());
            }
        } catch (IOException e) {
            System.out.println("fff");
        }

        discount = listOfPrices.get(listOfPrices.size() - 1);
        listOfPrices.remove(listOfPrices.size() - 1);
    }

    private void setUpForTwo() {
        try (FileReader fr = new FileReader("test2.in");
             Scanner scanner = new Scanner(fr)) {
            while (scanner.hasNextLine()) {
                listOfPrices.add(scanner.nextInt());
            }
        } catch (IOException e) {
            System.out.println("fff");
        }

        discount = listOfPrices.get(listOfPrices.size() - 1);
        listOfPrices.remove(listOfPrices.size() - 1);
    }

    private void setUpForThree() {
        try (FileReader fr = new FileReader("test3.in");
             Scanner scanner = new Scanner(fr)) {
            while (scanner.hasNextLine()) {
                listOfPrices.add(scanner.nextInt());
            }
        } catch (IOException e) {
            System.out.println("fff");
        }

        discount = listOfPrices.get(listOfPrices.size() - 1);
        listOfPrices.remove(listOfPrices.size() - 1);
    }

    @Test
    public void testOneCalculateTotalPrice() {
        setUpForOne();
        Assert.assertEquals(800.0, shop.calculateTotalPrice(discount, listOfPrices), 0);
    }


    @Test
    public void testTwoCalculateTotalPrice() {
        setUpForTwo();
        Assert.assertEquals(600.0, shop.calculateTotalPrice(discount, listOfPrices), 0);
    }

    @Test
    public void testThreeCalculateTotalPrice() {
        setUpForThree();
        Assert.assertEquals(350.0, shop.calculateTotalPrice(discount, listOfPrices), 0);
    }
}
