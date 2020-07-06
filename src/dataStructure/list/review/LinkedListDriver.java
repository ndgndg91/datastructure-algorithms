package dataStructure.list.review;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDriver {

    public static void main(String[] args) {
        List<Long> list = new LinkedList<>();
        list.add(1L);

        dataStructure.list.review.LinkedList<Long> linkedList = new dataStructure.list.review.LinkedList<>();
        linkedList.add(1L);
        linkedList.add(2L);

        for (Long l : linkedList) {
            System.out.println(l);
        }
    }
}
