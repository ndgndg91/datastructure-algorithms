package datastructure.algorithms.datastructure.udemy.list;

public class EmployeeDoubleLinkedListDriver {

    public static void main(String[] args) {
        var 남동길 = new Employee("남동길", 1);
        var 김철수 = new Employee("김철수", 2);
        var 김영희 = new Employee("김영희", 3);

        EmployeeDoubleLinkedList list = new EmployeeDoubleLinkedList();
        System.out.println("list is empty : " + list.isEmpty() + "\t list size is : " + list.size());
        list.addToFront(남동길);
        System.out.println("list is empty : " + list.isEmpty() + "\t list size is : " + list.size());
        list.addToFront(김철수);
        System.out.println("list is empty : " + list.isEmpty() + "\t list size is : " + list.size());
        list.addToEnd(김영희);
        System.out.println("list is empty : " + list.isEmpty() + "\t list size is : " + list.size());

        System.out.println(list);


        Employee removed1 = list.removeFromEnd();
        System.out.println("마지막 삭제");
        System.out.println("삭제 :" + removed1);
        System.out.println(list);
        System.out.println("list is empty : " + list.isEmpty() + "\t list size is : " + list.size());

        Employee removed2 = list.removeFromFront();
        System.out.println("처음 삭제");
        System.out.println("삭제 : " + removed2);
        System.out.println(list);
        System.out.println("list is empty : " + list.isEmpty() + "\t list size is : " + list.size());

        Employee removed3 = list.removeFromFront();
        System.out.println("처음 삭제");
        System.out.println("삭제 : " + removed3);
        System.out.println(list);
        System.out.println("list is empty : " + list.isEmpty() + "\t list size is : " + list.size());


        var 아무개 = new Employee("아무개", 4);
        list.addToEnd(아무개);

        System.out.println(list);
        System.out.println("list is empty : " + list.isEmpty() + "\t list size is : " + list.size());


    }
}
