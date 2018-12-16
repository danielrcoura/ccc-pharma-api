package com.cccpharmaapi.cccpharmaapi.Util;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;

import java.util.Comparator;

public class EstoqueComparator implements Comparator<Estoque> {
    @Override
    public int compare(Estoque estoque, Estoque t1) {
        return estoque.compareTo(t1);
    }
}
