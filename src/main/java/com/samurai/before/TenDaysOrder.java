package com.samurai.before;

import java.time.LocalDate;

public record TenDaysOrder(
        LocalDate deliveryDate,
        Integer deliveryQuantity
) {
}
