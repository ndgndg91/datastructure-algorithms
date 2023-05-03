package datastructure.algorithms.algorithms.coursea.dynamicconnectivity.driver;

import datastructure.algorithms.algorithms.coursea.dynamicconnectivity.QuickUnionUF;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuickUnionUFDriver {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/dynamic-connectivity.txt")) ) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            String[] tokens = sb.toString().split("\n");
            QuickUnionUF uf = new QuickUnionUF(Integer.parseInt(tokens[0]));

            for (int i = 1; i < tokens.length; i++) {
                String[] numbers = tokens[i].split(" ");
                uf.union(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
                System.out.println(uf);
            }

            System.out.println(uf);
            System.out.println(uf.connected(3,4));
            System.out.println(uf.connected(1,3));
            System.out.println(uf.connected(1,9));
            System.out.println(uf.connected(0,5));
            System.out.println(uf.connected(1,6));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
