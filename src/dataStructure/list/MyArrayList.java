package dataStructure.list;

import java.lang.reflect.Array;
import java.util.*;

public class MyArrayList<T> implements Iterable<T>{
    private T[] list;
    private final Class<T> type;
    private int current;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings(value = "unchecked")
    public MyArrayList(Class<T> type) {
        this.type = type;
        list = (T[]) Array.newInstance(type, DEFAULT_CAPACITY);
        current = 0;
    }

    @SuppressWarnings(value = "unchecked")
    public void add(T element) {
        if (current == list.length){
            T[] temp = (T[]) Array.newInstance(this.type, list.length * 2);
            System.arraycopy(this.list, 0, temp, 0, this.list.length);
            this.list = temp;
        }
        list[current++] = element;
    }

    public void add(int idx, T element) {
        if (idx < 0 || idx > current)
            throw new ArrayIndexOutOfBoundsException();
        add(element);

        if (current - 1 - idx >= 0)
            //list[idx] 부터 list[idx+1] 에 끝까지 복
            System.arraycopy(list, idx, list, idx + 1, current - 1 - idx);

        this.list[idx] = element;
    }

    public T remove(int idx) {
        T element = get(idx);
        remove(element);
        return element;
    }

    public boolean remove(T element) {
        for (int i = 0; i < current; i++) {
            if (Objects.equals(element, list[i])) {
                shift(i);
                current--;
                return true;
            }
        }

        return false;
    }

    private void shift(int idx){
        if (current - idx >= 0) System.arraycopy(list, idx + 1, list, idx, current - idx);
    }

    public boolean removeAll(Collection<T> collection) {
        boolean flag = false;
        for (T obj : collection) {
            flag |= remove(obj);
        }

        return flag;
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
    @SuppressWarnings(value = "unchecked")
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
            System.out.print(myArrayList.get(i) + " ");
        }
        System.out.println();
        System.out.println("iterator");
        Iterator iterator = myArrayList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("foreach");
        for (int i : myArrayList) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("test");
        myArrayList.forEach((item) -> System.out.print(item + " ") );
        System.out.println();

        MyArrayList<Developer> developers = new MyArrayList<>(Developer.class);
        Developer ndg = new Developer("남동길", 29, "JAVA");
        developers.add(ndg);
        Developer kdb = new Developer("김동범", 28, "JAVA");
        developers.add(kdb);
        Developer ejh = new Developer("은종현", 28, "JAVA");
        developers.add(ejh);

        System.out.println(developers.size());
        for (Developer d : developers) {
            System.out.println(d);
        }

        developers.remove(ndg);
        developers.remove(1);
        System.out.println("iterator");
        Iterator<Developer> iteratorDeveloper = developers.iterator();
        while (iteratorDeveloper.hasNext()) {
            System.out.println(iteratorDeveloper.next());
        }

        System.out.println("toArray()");
        Developer[] developersArr = (Developer[]) developers.toArray();

        for (int i = 0 ; i < developersArr.length; i++) {
            System.out.println(developersArr[i]);
        }

        System.out.println("object array");
        Object[] objectArr = developers.toArray();
        for (Object o : objectArr) {
            System.out.println(o);
        }

        developers.add(ndg);
        developers.add(ejh);

        System.out.println(developers.size());
        for (Developer d : developers) {
            System.out.println(d);
        }

        List<Developer> collection = new ArrayList<>();
        collection.add(ndg);
        collection.add(kdb);
        collection.add(ejh);

        developers.removeAll(collection);
        System.out.println(developers.size());
        for (Developer d : developers) {
            System.out.println(d);
        }
    }

    static class Developer{
        private final String name;
        private final int age;
        private final String mainLanguage;

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
