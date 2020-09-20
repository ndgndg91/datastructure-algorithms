package test.exception;

public class CheckedExceptionTest {

    public static void main(String[] args) {
        Class<?> aClass = getClassCatch("test.exception.ArrayIndexOutOfBoundsTest");
        System.out.println(aClass);

        try {
            Class<?> classThrowException = getClassThrowException("test.exception.ArrayIndexOutOfBoundsTest");
            System.out.println(classThrowException);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Class<?> getClassCatch(String className) {
        Class<?> aClass = null;
        try {
            aClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return aClass;
    }

    public static Class<?> getClassThrowException(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }
}
