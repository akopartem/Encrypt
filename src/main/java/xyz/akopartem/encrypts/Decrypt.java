package xyz.akopartem.encrypts;

import java.math.BigInteger;
import java.util.Objects;

public class Decrypt {
    public static String decryptString(String s) {
        String[] a = s.split("\\.");
        StringBuilder res = new StringBuilder();
        int d = getIndexInFib(a[0]);
        for (String value : a) {
            if (Objects.equals(value, a[0])) continue;
            res.append(Encrypt.alph.get(getIndexInFib(value) - 1 - d));
        }
        return res.toString();
    }

    public static int getIndexInFib(String s) {
        BigInteger b = new BigInteger(s, Encrypt.RADIX);
        b = new BigInteger(b.toString(10));
        return findIndexOfFibonacciWithDivisor(b);
    }
    public static int findIndexOfFibonacciWithDivisor(BigInteger divisor) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int index = 2;
        while (true) {
            index++;
            BigInteger c = b.add(a);
            if (c.mod(divisor).equals(BigInteger.ZERO)) return index;
            a = b;
            b = c;
        }
    }
}
