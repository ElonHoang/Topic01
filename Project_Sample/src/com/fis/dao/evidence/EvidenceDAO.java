package com.fis.dao.evidence;
import com.fis.module.evidence.Evidence;

import java.util.List;

public interface EvidenceDAO {
    public void add(Evidence o);
    public List<Evidence> getAll();
    public Evidence update(Evidence o);
    public void delete(int code);
}
