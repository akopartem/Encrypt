package xyz.akopartem.encrypts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Encrypt {
    final static int RADIX = 36;
    final static ArrayList<String> alph = new ArrayList<>(Arrays.asList("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя![]\\| ./@();:'\"<>-_=+*&^%$#`~, \n".split("")));

    public static String encryptString(String str) {
        StringBuilder res = new StringBuilder();
        int d = (int) (Math.random() * 50);
        while (d < 3) {
            d = (int) (Math.random() * 50);
        }
        res.append(getFib(d)).append(".");
        for (String s : str.split("")) {
            res.append(getFib(alph.indexOf(s) + 1 + d)).append(".");
        }
        return res.substring(0, res.toString().length() - 1);
    }

    private static String getFib(int n) {
        BigInteger x = BigInteger.valueOf(1);
        BigInteger y = BigInteger.valueOf(1);
        for (long i = 2; i < n; i++) {
            y = x.add(y);
            x = y.subtract(x);
        }
        return y.toString(Encrypt.RADIX);
    }
}
