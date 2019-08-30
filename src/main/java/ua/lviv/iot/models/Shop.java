package ua.lviv.iot.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {

    public static double calculateTotalPrice(int discount, List<Integer> listOfPrices) {

        double totalPrice = 0;

        for (int i = 0; i < listOfPrices.size(); i++) {
            int max = listOfPrices.get(i);
            int maxIndex = i;
            for (int k = i; k < listOfPrices.size(); k++) {
                if (max < listOfPrices.get(k)) {
                    max = listOfPrices.get(k);
                    maxIndex = k;
                }
            }
            if (maxIndex != i) {
                int temp = listOfPrices.get(i);
                listOfPrices.set(i, listOfPrices.get(maxIndex));
                listOfPrices.set(maxIndex, temp);
            }
        }

        if (listOfPrices.size() % 3 == 0) {
            for (int i = 0; i < listOfPrices.size(); i++) {
                if (i < listOfPrices.size() / 3 && discount != 0) {
                    totalPrice += listOfPrices.get(i) * discount / 100;
                } else {
                    totalPrice += listOfPrices.get(i);
                }
            }
        } else if (listOfPrices.size() % 3 == 2) {
            for (int i = 0; i < listOfPrices.size(); i++) {
                if (i < (listOfPrices.size() - 2) / 3  && discount != 0) {
                    totalPrice += listOfPrices.get(i) * discount / 100;
                } else {
                    totalPrice += listOfPrices.get(i);
                }
            }
        } else if (listOfPrices.size() % 3 == 1) {
            for (int i = 0; i < listOfPrices.size(); i++) {
                if (i < (listOfPrices.size() - 1) / 3  && discount != 0) {
                    totalPrice += listOfPrices.get(i) * discount / 100;
                } else {
                    totalPrice += listOfPrices.get(i);
                }
            }
        }
        return totalPrice;
    }

    public static void writeToFile(double totalPrice) {

        File myFile = new File("discnt .out");

        try (FileOutputStream fos = new FileOutputStream(myFile); // відкриває потік
             OutputStreamWriter osw = new OutputStreamWriter(fos); // трансформує текст вбайти
             BufferedWriter bufWriter = new BufferedWriter(osw);) { // буферизує текст

            bufWriter.write(Double.toString(totalPrice));

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public static void main(String[] args) {

        List<Integer> listOfPrices = new ArrayList<>();
        int discount;

        try (FileReader fr = new FileReader("test1.in");
             Scanner scanner = new Scanner(fr)) {
            while (scanner.hasNextLine()) {
                listOfPrices.add(scanner.nextInt());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        discount = listOfPrices.get(listOfPrices.size() - 1);
        listOfPrices.remove(listOfPrices.size() - 1);

        writeToFile(calculateTotalPrice(discount, listOfPrices));
    }
}
