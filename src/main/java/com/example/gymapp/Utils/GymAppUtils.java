package com.example.gymapp.Utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class GymAppUtils {

    public static String getCurrentTimestampStringInUTC() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneId.of("UTC")).format(Instant.now());
    }
}
