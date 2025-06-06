package com.samurai.before;

import java.time.LocalDate;

public record TenDaysCustomerOrder(
        LocalDate deliveryDate,
        Integer deliveryQuantity
) {
}
