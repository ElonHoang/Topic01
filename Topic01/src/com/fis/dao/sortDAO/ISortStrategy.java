package com.fis.dao.sortDAO;

import java.util.Comparator;

public interface ISortStrategy {
    public void sort(Comparable[] data, int count);
}
