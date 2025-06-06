package com.samurai.after;

import java.time.LocalDate;

public record TenDaysCustomerOrder(
        LocalDate deliveryDate,
        Integer deliveryQuantity
) {
}
