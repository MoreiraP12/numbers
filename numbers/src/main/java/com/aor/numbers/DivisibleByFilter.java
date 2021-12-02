package com.aor.numbers;

import java.util.List;

public class DivisibleByFilter implements GenericListFilter {
    Integer number ;
    public DivisibleByFilter(Integer newNumber) {
        number=newNumber;
    };
    @Override
    public boolean accept(Integer div) {
        return (div%number==0);
    }
}
