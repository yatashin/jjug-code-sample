package com.samurai.after;

import com.samurai.OrderDate;
import com.samurai.ProductionPlan;
import com.samurai.TenDaysOrder;
import com.samurai.OrderQuantity;

import java.util.List;
import java.util.Map;

public class TenDaysOrderCalculator {

    WorkingDaysCalculator workingDaysCalculator;
    OrderQuantityAllocator orderQuantityAllocator;

    public TenDaysOrderCalculator() {
        this.workingDaysCalculator = new WorkingDaysCalculator();
        this.orderQuantityAllocator = new OrderQuantityAllocator();
    }

    public List<ProductionPlan> calculate(TenDaysOrder tenDaysOrder) {
        var firstDateOfTenDays = tenDaysOrder.deliveryDate();
        var workingDays = workingDaysCalculator.calculate(firstDateOfTenDays);

        return orderQuantityAllocator.allocate(workingDays, tenDaysOrder.deliveryQuantity());
    }
}