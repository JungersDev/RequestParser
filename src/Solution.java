import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * create by Zaryvnoire Alexandr on 29.11.2022
 **/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        url = url.replaceFirst("\\S*\\?", "");
        String[] arguments = url.split("&");
        String result = null;
        Double doubleResult = null;
        String stringResult = null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arguments.length; i++) {
            String str;
            str = arguments[i].replaceFirst("\\=.+", "");
            result = sb.append(str).append(" ").toString();

            if (str.equals("obj")) {
                try {
                    doubleResult = Double.parseDouble(arguments[i].replaceFirst("\\w{3,}=", ""));
                } catch (NumberFormatException e) {
                    stringResult = arguments[i].replaceFirst("\\w{3,}=", "");
                }
            }

        }
        System.out.println(result);
        if (doubleResult != null) {
            alert(doubleResult);
        } else if (stringResult != null) {
            alert(stringResult);
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
