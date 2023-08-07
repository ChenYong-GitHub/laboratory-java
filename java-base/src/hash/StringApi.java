package hash;

import java.math.BigDecimal;

public class StringApi {

    public static void main(String[] args) {
//        BigDecimal b = null;
//        String s = String.valueOf(b);
//        System.out.println(s);


//        String ss = "";
//        BigDecimal bigDecimal = new BigDecimal(ss);
//        System.out.println(bigDecimal);

        StringBuilder sb = new StringBuilder();
        sb.append("abc").append(",");
        System.out.println(sb.substring(0, sb.length() - 1));

    }
}
