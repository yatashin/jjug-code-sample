package com.samurai.before;

import java.time.LocalDate;

public record OrderDate(
        LocalDate date,
        DateUnit dateUnit
) {
}
