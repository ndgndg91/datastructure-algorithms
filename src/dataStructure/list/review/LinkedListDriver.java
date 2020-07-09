package dataStructure.list.review;


public class LinkedListDriver {

    public static void main(String[] args) {
        linkedList();
//        long start = System.currentTimeMillis();
//        divideOperations();
//        bitOperations();
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);

    }

    private static int[] divideOperations(){
        int loop = 2000000000;
        int[] result = new int[loop+1];
        for (int idx = 1; idx <= loop; idx++) {
            result[idx] = idx / 2;
        }

        for (int idx = 1; idx <= loop; idx++) {
            result[idx] = result[idx] + idx / 2;
        }

        return result;
    }

    private static int[] bitOperations(){
        int loop = 2000000000;
        int[] result = new int[loop + 1];
        for (int idx = 1; idx <= loop; idx++) {
            result[idx] = idx >> 1;
        }

        for (int idx = 1; idx <= loop; idx++) {
            result[idx] = result[idx] + idx >> 1;
        }

        return result;
    }

    private static void linkedList() {
        LinkedList<Long> linkedList = new LinkedList<>();
        linkedList.add(1L);
        linkedList.add(2L);
        linkedList.add(200L);
        linkedList.add(300L);
        linkedList.addFirst(0L);
        System.out.println(linkedList.size());

        for (Long l : linkedList) {
            System.out.println(l);
        }

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(linkedList.size() - 1));
        System.out.println(linkedList.get(2));
    }
}
