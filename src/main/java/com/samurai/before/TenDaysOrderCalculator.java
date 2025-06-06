package com.samurai.before;

import com.samurai.DateUnit;
import com.samurai.OrderDate;
import com.samurai.OrderQuantity;
import com.samurai.TenDaysOrder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TenDaysOrderCalculator {

    public Map<OrderDate, OrderQuantity> dailySplitBy(TenDaysOrder tenDaysOrder) {
        var result = new HashMap<OrderDate, OrderQuantity>();

        var firstDate = tenDaysOrder.deliveryDate();
        var tenDaysOrderQuantity = tenDaysOrder.deliveryQuantity().quantity();
        var leftQuantity = tenDaysOrderQuantity;

        var weekDayCount = countWeekDays(firstDate);
        var average = tenDaysOrderQuantity / weekDayCount;
        var remainder = tenDaysOrderQuantity % weekDayCount;

        for (var i = 0; i < 10; i++) {
            var currentDate = firstDate.plusDays(i);
            if (firstDate.getMonth() != currentDate.getMonth()) {
                break;
            }

            if (!isWeekDay(currentDate)) {
                continue;
            }

            var orderDate = new OrderDate(firstDate.plusDays(i), DateUnit.DAILY);
            var quantity = average;

            if (remainder > 0) {
                quantity += 1;
                remainder -= 1;
            }

            if (leftQuantity == 0) {
                quantity = 0;
            }

            var orderQuantity = new OrderQuantity(quantity);

            result.put(orderDate, orderQuantity);

            leftQuantity -= quantity;
        }

        return result;
    }

    public Integer countWeekDays(LocalDate targetDate) {
        var count = 0;
        var date = targetDate;

        for (int i = 0; i < 10; i++) {
            if (targetDate.getMonth() != date.getMonth()) {
                break;
            }

            if (isWeekDay(date)) {
                count += 1;
            }

            date = date.plusDays(1);
        }

        return count;
    }

    private boolean isWeekDay(LocalDate date) {
        return !(date.getDayOfWeek() == DayOfWeek.SATURDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY);
    }
}