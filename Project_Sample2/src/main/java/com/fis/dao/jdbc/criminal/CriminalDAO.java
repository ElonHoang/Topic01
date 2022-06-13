package com.fis.dao.jdbc.criminal;

import com.fis.core.model.CriminalCase;
import com.fis.core.model.Detective;

import java.util.List;

public interface CriminalDAO {
    public void add(CriminalCase o);

    public CriminalCase getCriminalById(long id);
    public List<CriminalCase> getAll();
    public CriminalCase update(CriminalCase o);
    public void delete(Long code);
}
