package com.coffeetory.lib.format;

import java.text.DecimalFormat;

@SuppressWarnings("unused")
public class MessageFormat {

    public static String number(double d) {
        return new DecimalFormat("#,###").format(Math.floor(d));
    }

}
