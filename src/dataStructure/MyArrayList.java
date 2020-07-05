package dataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T>{
    private T[] list;
    private Class<T> type;
    private int current;
    private int maxSize;
    private static final int increment = 10;

    public MyArrayList(Class<T> type) {
        this.type = type;
        list = (T[]) Array.newInstance(type, increment);
        current = 0;
        maxSize = increment;
    }

    public void add(T element) {
        if (current == maxSize){
            T[] temp = (T[]) Array.newInstance(this.type, maxSize + increment);
            System.arraycopy(this.list, 0, temp, 0, this.list.length);
            this.list = temp;
        }
        list[current++] = element;
    }

    public void add(int idx, T element) {
        if (idx > current)
            throw new ArrayIndexOutOfBoundsException();
        this.list[idx] = element;
    }

    public int size(){
        return current;
    }

    public void clear(){
        Arrays.fill(list, 0);
        current = 0;
    }
    public T get(int idx) {
        return this.list[idx];
    }

    public Object[] toArray(){
        return this.list;
    }


    @Override
    public Iterator<T> iterator() {
        T[] temp = (T[]) Array.newInstance(this.type, this.current);
        System.arraycopy(this.list, 0, temp, 0, current);
        return Arrays.asList(temp).iterator();
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(Integer.class);
        System.out.println(myArrayList.size());
        myArrayList.add(1);
        System.out.println(myArrayList.size());
        myArrayList.clear();
        System.out.println(myArrayList.size());

        for (int i = 1; i < 13; i++) {
            myArrayList.add(i);
        }
        System.out.println(myArrayList.size());
        System.out.println();
        myArrayList.add(1, 100);
        for (int i = 0; i < myArrayList.size(); i++){
            System.out.println(myArrayList.get(i));
        }
        System.out.println("iterator");
        Iterator iterator = myArrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("foreach");
        for (int i : myArrayList) {
            System.out.println(i);
        }


        System.out.println("test");
        myArrayList.forEach((item) -> System.out.println(item) );


        MyArrayList<Developer> developers = new MyArrayList<>(Developer.class);
        developers.add(new Developer("남동길", 29, "JAVA"));
        developers.add(new Developer("김동범", 28, "JAVA"));
        developers.add(new Developer("은종현", 28, "JAVA"));

        System.out.println(developers.size());
        for (Developer d : developers) {
            System.out.println(d);
        }

        Iterator<Developer> iteratorDeveloper = developers.iterator();
        while (iteratorDeveloper.hasNext()) {
            System.out.println(iteratorDeveloper.next());
        }

        System.out.println("toArray()");
        Developer[] developersArr = (Developer[]) developers.toArray();
        Object[] objectArr = developers.toArray();
        for (int i = 0 ; i < developersArr.length; i++) {
            System.out.print(developersArr[i]+" ");
            System.out.print(objectArr[i]);
            System.out.println();
        }
    }

    static class Developer{
        private String name;
        private int age;
        private String mainLanguage;

        Developer(String name , int age, String mainLanguage) {
            this.name = name;
            this.age = age;
            this.mainLanguage = mainLanguage;
        }

        @Override
        public String toString() {
            return "Developer{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", mainLanguage='" + mainLanguage + '\'' +
                    '}';
        }
    }

}
