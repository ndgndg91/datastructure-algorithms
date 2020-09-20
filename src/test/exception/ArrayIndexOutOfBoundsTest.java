package test.exception;

public class ArrayIndexOutOfBoundsTest {
    private static final Mountain[] range = new Mountain[10000000];


    public static void main(String[] args){
        makeMountains();
        long start = System.currentTimeMillis();
        try {
            int i = 0;
            while (true) {
                range[i++].climb();
            }
        } catch (IndexOutOfBoundsException e) {}
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        for (Mountain m : range)
            m.climb();
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void makeMountains(){
        for (int i = 0; i < range.length; i++){
            range[i] = new Mountain();
        }
    }

    private static class Mountain{
        public void climb(){
            int a =  100;
            int b = 1000;
            int c = a * b;
            int d = c / a;
            int e = d + b;
            double f = Math.pow(e, 2);
            double g = f + e;
            int h = (int) g >> 1;
        }
    }
}
