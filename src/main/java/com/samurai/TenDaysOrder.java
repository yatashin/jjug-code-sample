package com.samurai;

import java.time.LocalDate;

public record TenDaysOrder(
        LocalDate deliveryDate,
        OrderQuantity deliveryQuantity
) {
}
