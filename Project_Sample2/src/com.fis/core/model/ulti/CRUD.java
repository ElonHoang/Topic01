package com.fis.core.model.ulti;

import java.util.ArrayList;
import java.util.List;

public interface CRUD {
    List<Object> list = new ArrayList<>();
    public void add(Object o);
    public List<Object>getAll(List<Object> obj);
    public Object update(Object o);
    public void delete(int code);
}
