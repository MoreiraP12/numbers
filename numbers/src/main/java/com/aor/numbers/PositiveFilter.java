package com.aor.numbers;

public class PositiveFilter implements GenericListFilter{
    Integer number ;
    public PositiveFilter() {};

    @Override
    public boolean accept(Integer nNumber) {
        return (nNumber >= 0);
    }
}

