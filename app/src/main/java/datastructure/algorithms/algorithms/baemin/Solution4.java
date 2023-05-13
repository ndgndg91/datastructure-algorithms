package datastructure.algorithms.algorithms.baemin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution4 {

    private static final Pattern pattern = Pattern.compile("^/payment/([0-9]{1,9})/([a-zA-Z]{1,10})$");
    private static final String ERROR = "error";

    public String solution(String pathVariableUrl) {
        Matcher matcher = pattern.matcher(pathVariableUrl);
        if (matcher.find()) {
            return "/payment/" + matcher.group(2) + "?paymentId=" + matcher.group(1);
        } else {
            return ERROR;
        }
    }

}
