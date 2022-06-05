package com.fis.dao.criminal;

import com.fis.model.CriminalCase;

import java.util.ArrayList;
import java.util.List;

public class CriminalDAOImp implements  CriminalDAO{
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
        CriminalCase c = new CriminalCase();
        if(c.getNumber().equals(o.getNumber())){
            o.setType(c.getType());
            o.setShortDescription(c.getShortDescription());
            o.setDetailedDescription(c.getDetailedDescription());
            o.setStatus(c.getStatus());
            o.setNotes(c.getNotes());
            o.setEvidenceSet(c.getEvidenceSet());
            o.setLeadInvestigator(c.getLeadInvestigator());
            o.setAssigned(c.getAssigned());
        }
        return o;
    }

    @Override
    public void delete(String code) {
    criminalCaseList.removeIf(t->t.getNumber().equals(code));
    }
}
