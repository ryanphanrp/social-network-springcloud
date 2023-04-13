package com.ryan.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

public class DatetimeUtils {
    private static final String ZONE_ID = "Asia/Ho_Chi_Minh";

    private DatetimeUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Long unixTimeOf(LocalDateTime time) {
        if (Objects.isNull(time)) return 0L;
        return time.atZone(ZoneId.of(ZONE_ID)).toEpochSecond();
    }
}
