package com.samurai;

import java.time.LocalDate;

public record OrderDate(
        LocalDate date,
        DateUnit dateUnit
) {
}
