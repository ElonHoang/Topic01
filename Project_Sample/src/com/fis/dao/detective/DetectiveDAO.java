package com.fis.dao.detective;

import com.fis.module.Detective;

import java.util.List;

public interface DetectiveDAO {
    public void add(Detective o);
    public List<Detective> getAll();
    public Detective update(Detective o);
    public void delete(int code);
}
