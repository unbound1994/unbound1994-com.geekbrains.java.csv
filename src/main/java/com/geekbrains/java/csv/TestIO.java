package com.geekbrains.java.csv;

import java.io.*;

public class TestIO {
    public static void main(String[] args) throws IOException {

        int a = 5;
        int b = 6;

        String[] headerMas = new String[b];
        for (int i = 0; i <headerMas.length ; i++) {
            headerMas[i] = "Value " + i;
        }

        int[][] dataMass = new int[a][b];
        for (int i = 0; i <dataMass.length ; i++) {
            for (int j = 0; j <dataMass[i].length ; j++) {
                dataMass[i][j] = (int) (Math.random() * 100);
            }
        }

        AppData value = new AppData(headerMas, dataMass);
        value.getHeader();

        try (PrintWriter ValueData = new PrintWriter("ValueDataOut.csv")) {
            for (int i = 0; i <value.getHeader().length-1 ; i++) {
                ValueData.print(value.getHeader()[i] + "; ");
            }
            ValueData.println(value.getHeader()[value.getHeader().length-1]);

            for (int i = 0; i < value.getData().length - 1; i++) {
                for (int j = 0; j < value.getData()[i].length-1; j++) {
                    ValueData.print(value.getData()[i][j] + "; ");
                }
                ValueData.println(value.getData()[i][value.getData()[i].length-1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader ValueData = new BufferedReader(new FileReader("ValueDataOut.csv"))) {
            String str = null;
            while ((str = ValueData.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}