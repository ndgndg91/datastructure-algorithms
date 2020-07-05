package algorithms.hackerrank.DesinerPDFViewer;

import java.io.*;
import java.util.*;

    public class Solution {

        // Complete the designerPdfViewer function below.
        static int designerPdfViewer(int[] h, String word) {
            int maxHeight = 0;
            for (int i = 0; i < word.length(); i++) {
                int temp = word.charAt(i) - 97;
                maxHeight = Math.max(maxHeight, h[temp]);
            }

            return word.length() * maxHeight;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            int[] h = new int[26];

            String[] hItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < 26; i++) {
                int hItem = Integer.parseInt(hItems[i]);
                h[i] = hItem;
            }

            String word = scanner.nextLine();

            int result = designerPdfViewer(h, word);
//            System.out.println(result);

            scanner.close();
        }
    }
