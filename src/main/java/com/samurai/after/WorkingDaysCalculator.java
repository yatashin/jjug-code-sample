package com.samurai.after;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkingDaysCalculator {
    public List<OrderDate> calculate(OrderDate orderDate) {
        var result = new ArrayList<OrderDate>();

        var date = orderDate.date();
        for (var i = 0; i <10; i++) {
            if (orderDate.date().getMonth() != date.getMonth()) {
                break;
            }

            if (isWeekDay(date)) {
                result.add(new OrderDate(date, DateUnit.DAILY));
            }

            date = date.plusDays(1);
        }
        return result;
    }

    private boolean isWeekDay(LocalDate date) {
        return !(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
    }
}
