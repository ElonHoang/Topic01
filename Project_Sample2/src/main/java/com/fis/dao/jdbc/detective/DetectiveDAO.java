package com.fis.dao.jdbc.detective;

import com.fis.core.model.Detective;
import com.fis.core.model.Person;

import java.util.List;

public interface DetectiveDAO {
    public void add(Detective o);
    public List<Detective> getAll();
    public Detective getDetectiveById(long id);
    public Detective update(Detective o);
    public void delete(Long code);

}
