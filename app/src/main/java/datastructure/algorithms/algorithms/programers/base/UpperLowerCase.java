package datastructure.algorithms.algorithms.programers.base;

import java.util.Scanner;

public class UpperLowerCase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < a.length(); i++) {
            if (Character.isUpperCase(a.charAt(i))) {
                builder.append(Character.toLowerCase(a.charAt(i)));
            } else {
                builder.append(Character.toUpperCase(a.charAt(i)));
            }
        }
        System.out.println(builder);
    }
}
