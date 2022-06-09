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
                o.setPerson(d.getPerson());
                o.setBadgeNumber(d.getBadgeNumber());
                o.setRank(d.getRank());
                o.setArmed(d.isArmed());
                o.setStatus(d.getStatus());
                o.setCriminalCase(d.getCriminalCase());
                o.setTrackEntries(d.getTrackEntries());
            }
        }

        return o;
    }

    @Override
    public void delete(Long code) {
        detectiveList.removeIf(t->t.getId() == code);
    }
}
