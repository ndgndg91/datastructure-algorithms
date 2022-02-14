package plainjava.classloader;

public class Main {

    public static void main(String[] args) {
        // ClassLoaderExample 의 Classloader 를 출력.
        // Application/System Classloader 가 해당 class 를 Load 한다.
        Class c = Main.class;
        System.out.println(c.getClassLoader());
        // String.class 은 built-in class 로 rt.jar 에 있다. 따라서 Bootstrap Classloader 의해서 load 된다.
        // null 로 출력된다.
        System.out.println(String.class.getClassLoader());
    }
}
