package com.fis.dao.evidence;

import com.fis.model.Evidence;

import java.util.ArrayList;
import java.util.List;

public class EvidenceDAOImp implements  EvidenceDAO{
    List<Evidence> evidenceList = new ArrayList<>();
    @Override
    public void add(Evidence o) {
    evidenceList.add(o);
    }

    @Override
    public List<Evidence> getAll() {
        return evidenceList;
    }

    @Override
    public Evidence update(Evidence o) {
        Evidence e = new Evidence();
        if(e.getCriminalCase().equals(o.getCriminalCase())){
            o.setStorage(e.getStorage());
            o.setNumber(e.getNumber());
            o.setItemName(e.getItemName());
            o.setNotes(e.getNotes());
            o.setArchired(e.isArchired());
            o.setTrackEntry(e.getTrackEntry());
        }
        return o;

    }

    @Override
    public void delete(Evidence code) {
    evidenceList.removeIf(t->t.getCriminalCase().equals(code.getCriminalCase()));
    }
}
