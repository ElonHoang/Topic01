package com.fis.dao.evidence;

import com.fis.core.model.Evidence;

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
        for(Evidence e : evidenceList){
            if(e.getId() == o.getId()){
                e.setCriminalCase(o.getCriminalCase());
                e.setStorage(o.getStorage());
                e.setNumber(o.getNumber());
                e.setItemName(o.getItemName());
                e.setNotes(o.getNotes());
                e.setArchired(o.isArchired());
                e.setTrackEntry(o.getTrackEntry());
            }
        }

        return o;

    }

    @Override
    public void delete(Long code) {
    evidenceList.removeIf(t->t.getId() == code);
    }
}
