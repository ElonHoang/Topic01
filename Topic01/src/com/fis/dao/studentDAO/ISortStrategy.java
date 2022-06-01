package com.fis.dao.studentDAO;

import java.util.Comparator;

public interface ISortStrategy {
    public void sort(Comparable[] data, int count);
}
