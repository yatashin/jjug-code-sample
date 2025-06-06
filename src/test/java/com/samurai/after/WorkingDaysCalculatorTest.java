package com.samurai.after;

import com.samurai.DateUnit;
import com.samurai.OrderDate;
import com.samurai.OrderQuantity;
import com.samurai.TenDaysOrder;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.google.common.truth.Truth.assertThat;

class WorkingDaysCalculatorTest {

    @Test
    public void test() {
        var calculator = new TenDaysOrderCalculator();
        var feb11th2025 = LocalDate.of(2025, 2, 11);

        var result = calculator.calculate(new TenDaysOrder(feb11th2025, new OrderQuantity(155)));

        assertThat(result).hasSize(8);
        assertThat(result.get(0).get(new OrderDate(feb11th2025, DateUnit.DAILY))).isEqualTo(new OrderQuantity(20));
    }

}