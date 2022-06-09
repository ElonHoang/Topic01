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
        for(Detective d : detectiveList){
            if(d.getId() == o.getId()){
                d.setPerson(o.getPerson());
                d.setBadgeNumber(o.getBadgeNumber());
                d.setRank(o.getRank());
                d.setArmed(o.isArmed());
                d.setStatus(o.getStatus());
                d.setCriminalCase(o.getCriminalCase());
                d.setTrackEntries(o.getTrackEntries());
            }
        }

        return o;
    }

    @Override
    public void delete(Long code) {
        detectiveList.removeIf(t->t.getId() == code);
    }
}
