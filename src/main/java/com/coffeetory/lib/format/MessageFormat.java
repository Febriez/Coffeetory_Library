package com.coffeetory.lib.format;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

@SuppressWarnings("unused")
public class MessageFormat {

    public static String m(double d) {
        return new DecimalFormat("#,###").format(Math.floor(d));
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull Component cp(String s) {
        return Component.text(s);
    }

}
