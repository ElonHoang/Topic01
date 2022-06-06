package com.fis.dao.detective;

import com.fis.core.model.Detective;

import java.util.ArrayList;
import java.util.List;

public class DetectiveDAOImp implements DetectiveDAO{
    List<Detective> detectiveList = new ArrayList<>();
    @Override
    public void add(Detective o) {
        detectiveList.add(o);
    }

    @Override
    public List<Detective> getAll() {
        return detectiveList;
    }

    @Override
    public Detective update(Detective o) {
        Detective d = new Detective();
        if(d.getPerson().equals(o.getPerson())){
            o.setBadgeNumber(d.getBadgeNumber());
            o.setRank(d.getRank());
            o.setArmed(d.isArmed());
            o.setStatus(d.getStatus());
            o.setCriminalCase(d.getCriminalCase());
            o.setTrackEntries(d.getTrackEntries());
        }
        return o;
    }

    @Override
    public void delete(Detective code) {
        detectiveList.removeIf(t->t.getPerson().equals(code.getPerson()));
    }
}
