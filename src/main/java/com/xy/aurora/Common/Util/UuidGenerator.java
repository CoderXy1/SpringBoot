package com.xy.aurora.Common.Util;

import java.util.UUID;

public class UuidGenerator {
    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
