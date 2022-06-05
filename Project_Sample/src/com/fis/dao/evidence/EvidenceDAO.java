package com.fis.dao.evidence;
import com.fis.model.CriminalCase;
import com.fis.model.Evidence;

import java.util.List;

public interface EvidenceDAO {
    public void add(Evidence o);
    public List<Evidence> getAll();
    public Evidence update(Evidence o);
    public void delete(Evidence code);
}
