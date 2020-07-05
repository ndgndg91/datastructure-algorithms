package algorithms.baekjoon;

public class PhoneBook {


    private static String[] case1 = {"119", "97674223", "1195524421"};
    private static String[] case2 = {"12232332", "12", "222222"};
    private static String[] case3 = {"113", "12340", "123440", "12345", "98346"};
    private static boolean answer;
    public static void main(String[] args){
        boolean result = solution(case1);
        System.out.println(result);

        result = solution(case2);
        System.out.println(result);
    }
    public static boolean solution(String[] phone_book) {
        for (int j = 0; j < phone_book.length; j++) {
            for (int i = 0; i < phone_book.length; i++) {
                if (i==j)continue;
                if (phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;
    }
}