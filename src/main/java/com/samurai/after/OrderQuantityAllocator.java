package com.samurai.after;

import com.samurai.OrderQuantity;
import com.samurai.OrderDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderQuantityAllocator {

    public List<Map<OrderDate, OrderQuantity>> allocate(List<OrderDate> workingDays, OrderQuantity orderQuantity) {
        var result = new ArrayList<Map<OrderDate, OrderQuantity>>();

        int quotient = orderQuantity.quantity() / workingDays.size();
        int remainder = orderQuantity.quantity() % workingDays.size();

        for (var orderDate: workingDays) {
            var extra = remainder > 0 ? 1 : 0;
            result.add(Map.of(orderDate, new OrderQuantity(quotient + extra)));

            remainder -= 1;
        }

        return result;
    }
}
