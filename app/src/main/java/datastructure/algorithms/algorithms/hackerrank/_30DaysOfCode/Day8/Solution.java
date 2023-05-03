package datastructure.algorithms.algorithms.hackerrank._30DaysOfCode.Day8;

//Complete this code or write your own from scratch
import java.util.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String, Integer> phoneBook = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phoneBook.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if(null == phoneBook.get(s))
                System.out.println("Not found");
            else
                System.out.println(s+"="+phoneBook.get(s));
        }
        in.close();
    }
}

