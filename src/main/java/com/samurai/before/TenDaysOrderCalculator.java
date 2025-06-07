package com.samurai.before;

import com.samurai.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TenDaysOrderCalculator {

    public List<ProductionPlan> dailySplitBy(TenDaysOrder tenDaysOrder) {
        var result = new ArrayList<ProductionPlan>();

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

            result.add(new ProductionPlan(orderDate, new OrderQuantity(quantity)));
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