package algorithms.codingtest.balancehero;

import java.util.*;

class BalanceHero {

    @Test
    void test(){
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4);


        System.out.println(Collections.binarySearch(list, 4));
    }

    @Test
    void treeSet(){
        //given
        TreeSet s1 = new TreeSet();
        TreeSet subset1 = new TreeSet();

//        604 606 608 610 612 614 616
        for (int i = 604; i < 617; i++) {
            if ( i%2 ==0)
                s1.add(i);
        }

        SortedSet sortedSet = s1.subSet(1, 700);
        subset1 = (TreeSet) s1.subSet(606, 613);
        s1.add(629);
        subset1.add(629);
        System.out.println(s1 + " " + subset1);

        //when

        //then
    }

    @Test
    void first(){
        int input1 = 6;
        int[] answer = new int[input1];
        int[] input2 = {4,9,5,3,2,10};
        for (int i = 0; i < input2.length; i++) {
            int currentTarget = input2[i];
            int value = 0;
            System.out.println("curr : " + currentTarget);
            System.out.print("previous students : ");
            for (int j = 0; j < i; j++) {
                if (currentTarget == input2[j]) continue;
                if (currentTarget < input2[j]) value++;
                System.out.print(input2[j] + "\t");
            }
            System.out.println();
            answer[i] = value;
        }


        for (int a : answer)
            System.out.print(a + "\t");
    }

    @Test
    void second() {
        int input1 = 5;
        int[] input2 = {1,2,9,9,9};
        int answer = 0;

        for (int i = input2.length - 1; i >= 0; i--) {
            if (input2[i] == 9) continue;
            answer = i + 1;
            break;
            System.out.println(input2[i]);
        }
    }
}
