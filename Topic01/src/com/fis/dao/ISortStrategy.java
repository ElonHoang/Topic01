package com.fis.dao;

import java.util.Comparator;

public interface ISortStrategy {
    public void sort(Comparable[] data, int count);
}
