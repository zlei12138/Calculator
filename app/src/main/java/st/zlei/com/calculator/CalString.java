package st.zlei.com.calculator;

/**
 * Created by Lurzeood on 2017/7/16 0016.
 */

import android.util.Log;

import java.math.BigDecimal;

public class CalString {
    /**
     * 两个字符类型的小数进行相加为a+b;
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBigDecimal(String a, String b) {
        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        BigDecimal a2 = BigDecimal.valueOf(a1);
        BigDecimal b2 = BigDecimal.valueOf(b1);
        BigDecimal c2 = a2.add(b2);
        String c1 = c2 + "";
        return c1;
    }

    /**
     * 两个字符类型的小数进行相减为a-b;
     *
     * @param a
     * @param b
     * @return
     */
    public static String reduceBigDecimal(String a, String b) {
        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        BigDecimal a2 = BigDecimal.valueOf(a1);
        BigDecimal b2 = BigDecimal.valueOf(b1);
        BigDecimal c2 = a2.subtract(b2);
        String c1 = c2 + "";
        return c1;
    }

    /**
     * 两个字符类型的数相乘 a*b=c；
     *
     * @param a
     * @param b
     * @return
     */
    public static String multipliedString(String a, String b) {
        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        BigDecimal a2 = BigDecimal.valueOf(a1);
        BigDecimal b2 = BigDecimal.valueOf(b1);
        BigDecimal c2 = a2.multiply(b2);
        String c1 = c2 + "";
        return c1;
    }

    /**
     * 两个字符类型的数相除 a/b=c；
     *
     * @param a
     * @param b
     * @return
     */
    public static String divideString(String a, String b) {
        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        BigDecimal a2 = BigDecimal.valueOf(a1);
        BigDecimal b2 = BigDecimal.valueOf(b1);
        BigDecimal c2 = a2.divide(b2, a2.scale());
        String c1 = c2 + "";
        return c1;
    }

    public static String yunsuanjibie(String s) {


        while (true) {
            if (s.contains("a")) {
                s = s.replace("a", "3.14") + "+0";
            } else {
                break;
            }
        }

        while (true) {
            if (s.contains("e")) {
                s = s.replace("e", "2.718") + "+0";
            } else {
                break;
            }
        }

        while (true) {
            if (s.contains("sin")) {
                s = rePlaceSin(s);
                s = s + "+0";
            } else {
                break;
            }
        }

        while (true) {
            if (s.contains("cos")) {
                s = rePlaceCos(s);
                s = s + "+0";
            } else {
                break;
            }
        }

        while (true) {
            if (s.contains("tan")) {
                s = rePlaceTan(s);
                s = s + "+0";
            } else {
                break;
            }
        }

        while (true) {
            if (s.contains("%")) {
                s = rePlacePercent(s);
                s = s + "+0";
            } else {
                break;
            }
        }

        boolean isFind = false;
        String r = "";
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*'
                    || s.charAt(i) == '/') {
                p++;
            }
        }
        String k[] = new String[2 * p + 1];
        int k1 = 0;
        int first = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*'
                    || s.charAt(i) == '/') {
                k[k1] = s.substring(first, i);
                k1++;
                k[k1] = "" + s.charAt(i);
                k1++;
                first = i + 1;
            }
        }
        k[k1] = s.substring(first, s.length());
        int kp = p;
        while (kp > 0) {
            for (int i = 0; i < k.length; i++) {
                if (k[i].equals("*") || k[i].equals("/")) {
                    isFind = true;
                    int l;
                    for (l = i - 1; l > -1; l--) {
                        if (!(k[l].equals("p")))
                            break;
                    }
                    int q;
                    for (q = i + 1; q < k.length; q++) {
                        if (!(k[l].equals("p")))
                            break;
                    }
                    if (k[i].equals("*")) {
                        k[i] = "" + multipliedString(k[l], k[q]);
                        k[l] = "p";
                        k[q] = "p";
                        kp--;
                    } else {
                        k[i] = "" + divideString(k[l], k[q]);
                        k[l] = "p";
                        k[q] = "p";
                        kp--;
                    }
                    break;
                }
            }
            if (isFind) {
                isFind = false;
                for (int i = 0; i < k.length; i++) {
                    if (!(k[i].equals("p"))) {
                        // System.out.println(r+"xxxxx"+i);
                        r = k[i];
                        break;
                    }
                }
                continue;
            }
            for (int i = 0; i < 2 * p + 1; i++) {
                if (k[i].equals("+") || k[i].equals("-")) {
                    int l;
                    for (l = i - 1; l > -1; l--) {
                        if (!(k[l].equals("p")))
                            break;
                    }
                    int q;
                    for (q = i + 1; q < k.length; q++) {
                        if (!(k[q].equals("p")))
                            break;
                    }
                    if (k[i].equals("+")) {
                        k[i] = "" + addBigDecimal(k[l], k[q]);
                        k[l] = "p";
                        k[q] = "p";
                        kp--;
                    } else {
                        k[i] = "" + reduceBigDecimal(k[l], k[q]);
                        k[l] = "p";
                        k[q] = "p";
                        kp--;
                    }
                    break;
                }
            }
            for (int i = 0; i < k.length; i++) {
                if (!(k[i].equals("p"))) {
                    // System.out.println(r+"xxxxx"+i);
                    r = k[i];
                    break;
                }
            }
        }
        return r;
    }

    private static String rePlaceSin(String s) {
        String num = null;
        int indexOf = s.indexOf("sin");
        int sinstop = 0;
        Log.e("SIN", "sizeyunsuan: " + indexOf);
        num = "";
        for (int i = 0; i < s.length() - 3 - indexOf; i++) {
            if (isNumeric(String.valueOf(s.charAt(indexOf + 3 + i))) || String.valueOf(s.charAt(indexOf + 3 + i)).equals(".")) {
                num += String.valueOf(s.charAt(indexOf + 3 + i));
                sinstop = indexOf + 3 + i;
            } else {
                if (i == 0) {
                    return "ERROR";
                } else {
                    break;
                }
            }
        }


        double sin = Math.sin(Math.toRadians(Double.parseDouble(num)));
        String s1 = s.substring(indexOf, sinstop + 1);
        String s2 = s.replace(s1, String.valueOf(sin));
        Log.e("SIN", "sizeyunsuan: " + s + "---" + s1 + "---" + s2);
        return s2;
    }

    private static String rePlaceCos(String s) {
        String num = null;
        int indexOf = s.indexOf("cos");
        int sinstop = 0;
        // Log.e("cos", "sizeyunsuan: " + indexOf);
        num = "";
        for (int i = 0; i < s.length() - 3 - indexOf; i++) {
            if (isNumeric(String.valueOf(s.charAt(indexOf + 3 + i))) || String.valueOf(s.charAt(indexOf + 3 + i)).equals(".")) {
                num += String.valueOf(s.charAt(indexOf + 3 + i));
                sinstop = indexOf + 3 + i;
            } else {
                if (i == 0) {
                    return "ERROR";
                } else {
                    break;
                }
            }
        }


        double cos = Math.cos(Math.toRadians(Double.parseDouble(num)));
        String s1 = s.substring(indexOf, sinstop + 1);
        String s2 = s.replace(s1, String.valueOf(cos));
        Log.e("COS", "sizeyunsuan: " + s + "---" + s1 + "---" + s2);
        return s2;
    }

    private static String rePlaceTan(String s) {
        String num = null;
        int indexOf = s.indexOf("tan");
        int sinstop = 0;
        // Log.e("TAN", "sizeyunsuan: " + indexOf);
        num = "";
        for (int i = 0; i < s.length() - 3 - indexOf; i++) {
            if (isNumeric(String.valueOf(s.charAt(indexOf + 3 + i))) || String.valueOf(s.charAt(indexOf + 3 + i)).equals(".")) {
                num += String.valueOf(s.charAt(indexOf + 3 + i));
                sinstop = indexOf + 3 + i;
            } else {
                if (i == 0) {
                    return "ERROR";
                } else {
                    break;
                }
            }
        }


        double tan = Math.tan(Math.toRadians(Double.parseDouble(num)));
        String s1 = s.substring(indexOf, sinstop + 1);
        String s2 = s.replace(s1, String.valueOf(tan));
        //Log.e("TAN", "sizeyunsuan: "+s+"---"+s1+"---"+s2 );
        return s2;
    }

    private static String rePlacePercent(String s) {
        String num = null;
        int indexOf = s.indexOf("%");
        int percentBegin = indexOf;
        // Log.e("TAN", "sizeyunsuan: " + indexOf);
        num = "";
        for (int i = indexOf ; i > 0; i--) {
            if (isNumeric(String.valueOf(s.charAt(i-1))) || String.valueOf(s.charAt(i-1)).equals(".")) {
                num = String.valueOf(s.charAt(i - 1))+num;
                percentBegin = i-1;
            } else {
                if (i == indexOf) {
                    return "ERROR";
                } else {
                    break;
                }

            }
        }


        String s1 = s.substring(percentBegin, indexOf);
        float aFloat = Float.parseFloat(num);
        float v = aFloat / 100;
        String s2 = s.replace(s1 + "%", String.valueOf(v));
        Log.e("TAN", "sizeyunsuan: " + s + "---" + s1 + "---" + s2);
        return s2;
    }


    public static String sizeyunsuan(String s) {
        while (true) {
            int first = 0;
            int last = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(')
                    first = i;
                if (s.charAt(i) == ')') {
                    last = i;
                    break;
                }
            }
            if (last == 0) {
                System.out.println("1" + s);
                String result = yunsuanjibie(s);
                System.out.println("2" + result);
                return result;
            } else {
                String s1 = s.substring(0, first);
                String s2 = s.substring(first + 1, last);
                String s3 = s.substring(last + 1, s.length());
                System.out.println(s1 + "---" + s2 + "----" + s3);
                s = s1 + yunsuanjibie(s2) + s3 + "+0";
            }

        }
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
