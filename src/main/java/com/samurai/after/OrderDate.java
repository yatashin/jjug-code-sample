package com.samurai.after;

import java.time.LocalDate;

public record OrderDate(
        LocalDate date,
        DateUnit dateUnit
) {
}
