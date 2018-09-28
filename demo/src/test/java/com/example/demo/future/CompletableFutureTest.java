package com.example.demo.future;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;

public class CompletableFutureTest {

    List<DailyClientRecon> dailyClientReconList = new ArrayList<DailyClientRecon>() {{
        add(new DailyClientRecon(1, 11, LocalDate.now(), new BigDecimal(20000.00), new BigDecimal(10.00), new BigDecimal(1000000.00), 2, "10000002", "A001"));
        add(new DailyClientRecon(2, 12, LocalDate.now(), new BigDecimal(20000.00), new BigDecimal(100.00), new BigDecimal(100000.00), 2, "10000002", "A001"));
        add(new DailyClientRecon(3, 13, LocalDate.now(), new BigDecimal(20000.00), new BigDecimal(1000.00), new BigDecimal(10000.00), 2, "10000002", "A001"));
        add(new DailyClientRecon(4, 14, LocalDate.now(), new BigDecimal(20000.00), new BigDecimal(10000.00), new BigDecimal(1000.00), 2, "10000002", "A001"));
        add(new DailyClientRecon(5, 15, LocalDate.now(), new BigDecimal(20000.00), new BigDecimal(100000.00), new BigDecimal(100.00), 2, "10000002", "A001"));
        add(new DailyClientRecon(6, 16, LocalDate.now(), new BigDecimal(20000.00), new BigDecimal(1000000.00), new BigDecimal(10.00), 2, "10000002", "A001"));
    }};



    public static void main(String[] args) {

    }

}
