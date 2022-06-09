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
                c.setNumber(o.getNumber());
                c.setType(o.getType());
                c.setShortDescription(o.getShortDescription());
                c.setDetailedDescription(o.getDetailedDescription());
                c.setStatus(o.getStatus());
                c.setNotes(o.getNotes());
                c.setEvidenceSet(o.getEvidenceSet());
                c.setLeadInvestigator(o.getLeadInvestigator());
                c.setAssigned(o.getAssigned());
            }
        }

        return o;
    }

    @Override
    public void delete(Long code) {
    criminalCaseList.removeIf(t->t.getId() == code);
    }
}
