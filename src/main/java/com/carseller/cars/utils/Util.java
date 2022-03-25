package com.carseller.cars.utils;

import java.util.Collection;

public class Util {

    private Util() {}

    public static boolean isFilled(Object obj) {
        return (obj != null);
    }

    public static boolean isFilled(String string) {
        return (string != null && !"".equals(string.trim()));
    }

    public static final boolean isFilled(Collection<?> collection) {
        return (collection != null && !collection.isEmpty());
    }

    public static final boolean isFilled(Object[] objArray) {
        return (objArray != null && objArray.length > 0);
    }
}
