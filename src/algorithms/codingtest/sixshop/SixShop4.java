package algorithms.codingtest.sixshop;

//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class SixShop4 {

    public static void main(String[] args) throws Exception{

        System.out.println("Testing 1 - Send Http GET request");
//        sendGet();

    }

    // HTTP GET request
//    private static String[] sendGet() {
//        ArrayList<String> list = new ArrayList<>();
//        int total = 0;
//        int totalPage = 0;
//        try {
//            String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman";
//            String response = sendGet(url);
//
//            //print result
////        System.out.println(response.toString());
//            JsonParser parser = new JsonParser();
//            JsonElement element = parser.parse(response);
//            System.out.println(element);
//            System.out.println(element.getAsJsonObject().get("total"));
//            total = element.getAsJsonObject().get("total").getAsInt();
//            totalPage = element.getAsJsonObject().get("total_pages").getAsInt();
//
//            int idx = 0;
//            for (int i = 1; i <= totalPage; i++) {
//                String tempResponse = sendGet(url + "&page=" + i);
//                JsonElement tempElement = parser.parse(tempResponse);
//                JsonArray jsonTitles = tempElement.getAsJsonObject().get("data").getAsJsonArray();
//                for (int j = 0; j < jsonTitles.size(); j++) {
////            System.out.println(name.get(i).getAsJsonObject().get("Title"));
//                    list.add(jsonTitles.get(j).getAsJsonObject().get("Title").getAsString());
////                    titles[idx++] = jsonTitles.get(j).getAsJsonObject().get("Title").getAsString();
//                }
//            }
//        }catch (Exception e){
//
//        }
//
//        String[] titles = new String[total];
//        for (int i =0; i < list.size(); i++) {
//            titles[i] = list.get(i);
//        }
//        Arrays.sort(titles);
//        return titles;
//    }
//
//    private static String sendGet(String url) throws Exception{
//        URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//        // optional default is GET
//        con.setRequestMethod("GET");
//
////        int responseCode = con.getResponseCode();
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//        return  response.toString();
//    }
}
