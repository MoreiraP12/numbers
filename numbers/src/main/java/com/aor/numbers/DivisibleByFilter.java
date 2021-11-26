package com.aor.numbers;

import java.util.List;

public class DivisibleByFilter {
    Integer number ;
    public DivisibleByFilter(Integer newNumber) {
        number=newNumber;
    };

    public boolean accept(Integer div) {
        return (div%number==0);
    }
}
