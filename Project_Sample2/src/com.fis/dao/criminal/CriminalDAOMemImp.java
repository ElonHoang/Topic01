package com.fis.dao.criminal;

import com.fis.core.model.CriminalCase;

import java.util.ArrayList;
import java.util.List;

public class CriminalDAOMemImp implements  CriminalDAO{
    List<CriminalCase> criminalCaseList = new ArrayList<>();
    @Override
    public void add(CriminalCase o) {
        criminalCaseList.add(o);
    }

    @Override
    public List<CriminalCase> getAll() {
        return criminalCaseList;
    }

    @Override
    public CriminalCase update(CriminalCase o) {
        for(CriminalCase c : criminalCaseList){
            if(c.getId() == o.getId()){
                o.setNumber(c.getNumber());
                o.setType(c.getType());
                o.setShortDescription(c.getShortDescription());
                o.setDetailedDescription(c.getDetailedDescription());
                o.setStatus(c.getStatus());
                o.setNotes(c.getNotes());
                o.setEvidenceSet(c.getEvidenceSet());
                o.setLeadInvestigator(c.getLeadInvestigator());
                o.setAssigned(c.getAssigned());
            }
        }

        return o;
    }

    @Override
    public void delete(Long code) {
    criminalCaseList.removeIf(t->t.getId() == code);
    }
}
