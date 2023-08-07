package base;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class DoubleDemo {

    public static void main(String[] args) {
        String value = "STAIR";
        Double v = StringUtils.isEmpty(value) ? 0D : (isDouble(value) ? Double.parseDouble(value) : null);
        System.out.println(v);
    }


    private static boolean isDouble(String str) {
        return Pattern.matches("^[-+]?\\d*\\.?\\d+$", str);
    }

}
