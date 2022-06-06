package com.fis.dao.criminal;

import com.fis.core.model.CriminalCase;

import java.util.List;

public interface CriminalDAO {
    public void add(CriminalCase o);
    public List<CriminalCase> getAll();
    public CriminalCase update(CriminalCase o);
    public void delete(Long code);
}
