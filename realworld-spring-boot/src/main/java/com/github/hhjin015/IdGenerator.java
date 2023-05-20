package com.github.hhjin015;

import lombok.RequiredArgsConstructor;
import java.time.Instant;

@RequiredArgsConstructor
public class IdGenerator {

    public static long get() {
        return Instant.now().toEpochMilli();
    }
}
