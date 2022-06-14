package com.fis.dao.jdbc.evidence;
import com.fis.core.model.Evidence;

import java.util.List;
import java.util.Set;

public interface EvidenceDAO {
    public void add(Evidence o);
    public List<Evidence> getAll();

    public Evidence getEvidenceById(long id);
    public Evidence update(Evidence o);
    public void delete(Long code);
}
