package algorithms.codingtest.crema;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Crema1 {
    /*
     * Complete the 'reformatDate' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY dates as parameter.
     */
    static HashMap<String, String> month = new HashMap<>();
    static {
        month.put("Jan","01");
        month.put("Feb","02");
        month.put("Mar","03");
        month.put("Apr","04");
        month.put("May","05");
        month.put("Jun","06");
        month.put("Jul","07");
        month.put("Aug","08");
        month.put("Sep","09");
        month.put("Oct","10");
        month.put("Nov","11");
        month.put("Dec","12");
    }
    public static List<String> reformatDate(List<String> dates) {
        // Write your code here
        ArrayList<String> reformatted = new ArrayList<>();
        Pattern suffix = Pattern.compile("th|rd|st|nd");
        for ( String date : dates) {
            String[] DDthMonYYYY = date.split(" ");
            Matcher matcher = suffix.matcher(DDthMonYYYY[0]);
            if(matcher.find()) {
                DDthMonYYYY[0] = DDthMonYYYY[0].replace(matcher.group(), "");
            }
            if (DDthMonYYYY[0].length() == 1)
                DDthMonYYYY[0] = "0"+DDthMonYYYY[0];
            DDthMonYYYY[1] = month.get(DDthMonYYYY[1]);
            StringBuilder temp = new StringBuilder();
            temp.append(DDthMonYYYY[2]);
            temp.append("-");
            temp.append(DDthMonYYYY[1]);
            temp.append("-");
            temp.append(DDthMonYYYY[0]);
            reformatted.add(temp.toString());
        }
        return reformatted;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int datesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dates = IntStream.range(0, datesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = reformatDate(dates);


        bufferedReader.close();
    }
}
