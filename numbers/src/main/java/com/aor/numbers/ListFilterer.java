package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer{
    private GenericListFilter filter;
    public ListFilterer(GenericListFilter filter) {this.filter = filter;};

    public List<Integer> filter(List<Integer> list) {
        ArrayList newList = new ArrayList<>();
        for(int number: list){
            if(filter.accept(number)){
                newList.add(number);
            }
        }
    return newList;}
}

