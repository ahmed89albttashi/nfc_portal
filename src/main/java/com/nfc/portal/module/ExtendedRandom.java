package com.nfc.portal.module;

import java.util.Random;

public class ExtendedRandom extends Random {
    private static final long serialVersionUID = 1L;

    public long nextLong(long n) {
        if (n <= 0L) throw new IllegalArgumentException();

        // for small n use nextInt and cast
        if (n <= Integer.MAX_VALUE) {
            return (long) nextInt((int) n);
        }

        // for large n use nextInt for both high and low ints
        int highLimit = (int) (n >> 32);
        long high = (long) nextInt(highLimit) << 32;
        long low = ((long) nextInt()) & 0xffffffffL;
        return (high | low);
    }

}
