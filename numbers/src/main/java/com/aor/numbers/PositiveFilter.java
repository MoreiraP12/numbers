package com.aor.numbers;

public class PositiveFilter {
    Integer number ;
    public PositiveFilter() {};

    public boolean accept(Integer nNumber) {
        return (nNumber >= 0);
    }
}

