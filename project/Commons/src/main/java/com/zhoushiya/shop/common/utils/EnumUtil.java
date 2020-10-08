package com.zhoushiya.shop.common.utils;

public class EnumUtil {
    public static <T extends BaseEnum> T getByKey(Integer key, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (key.equals(each.getKey())) {
                return each;
            }
        }
        return null;
    }
}
