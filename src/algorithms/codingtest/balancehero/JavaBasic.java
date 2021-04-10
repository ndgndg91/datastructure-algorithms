package algorithms.codingtest.balancehero;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JavaBasic {
    static int a=3;
    static int b;

    static void method(int x){
        System.out.println("x=" + x);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    static {
        System.out.println("a=" + a);
        b=a*4;
    }

    public static void main(String[] args){
        method(55);
    }
}


class Parent {
    void msg() throws Exception {
        System.out.println("parent");
    }
}

class Child extends Parent {
    void msg() throws ArithmeticException{
        System.out.println("child");
    }

    public static void main(String args[]) {
        Parent p = new Child(); // child
        try {
            p.msg();
        } catch (Exception e) {

        }
    }
}

class Test {
    // print only Hello
    public static void main(String[] args) {
        boolean t = true;
        System.out.println("Hello");

        if (t) return;

        System.out.println("Bye");
    }
}

class HandleFractions {
    // BigDecimal precise
    public static void main(String[] args) {
        String d1 = "39.13";
        String d2 = "100";
        String sAvg = String.valueOf(getAverageMethodA(d1, d2));
        String sAvg2 = String.valueOf(getAverageMethodB(d1, d2));
        String sAvg3 = String.valueOf(getAverageMethodC(d1, d2));
        System.out.println(sAvg + "---" + sAvg2 + "---" + sAvg3);
    }

    private static BigDecimal getAverageMethodA(String d1, String d2) {
        BigDecimal num1 = new BigDecimal(d1);
        BigDecimal num2 = new BigDecimal(d2);
        BigDecimal num3 = (num1.divide(num2));
        return num3;
    }

    private static double getAverageMethodB(String d1, String d2) {
        double num1 = Double.valueOf(d1);
        double num2 = Double.valueOf(d2);
        return num1/num2;
    }

    private static float getAverageMethodC(String d1, String d2) {
        float num1 = Float.valueOf(d1);
        float num2 = Float.valueOf(d2);
        return num1/num2;
    }
}

class Animal {}
class Dog extends Animal {}

class Main {
    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        Add(list);
    }

    // method signature
    public static void Add(List<Animal> adcd) {

    }
}

class OverloadingDemo {
    public static void main(String[] args) {
        // compile error
//        show(null);
    }

    public void show(Object o){
        System.out.println("hi");
    }

    public void show(String o){
        System.out.println("hi");
    }

    public void show(StringBuffer o){
        System.out.println("hi");
    }
}

class Parent2 {
    Parent2(int i) {
        System.out.println("parent");
    }
}

// compile error
//class Child2 extends Parent2 {
//    Child2(){
//        System.out.println("child");
//    }
//}
