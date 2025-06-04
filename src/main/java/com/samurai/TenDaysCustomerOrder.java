package com.samurai;

import java.time.LocalDate;

public record TenDaysCustomerOrder(
        LocalDate deliveryDate,
        Integer deliveryQuantity
) {
}
