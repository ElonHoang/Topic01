package com.fis.dao.jdbc.trackentry;

import com.fis.core.model.Storage;
import com.fis.core.model.TrackEntry;

import java.util.List;

public interface TrackEntryDAO {
    public void add(TrackEntry o);
    public List<TrackEntry> getAll();
    public TrackEntry getTrackEntryById(long id);
    public TrackEntry update(TrackEntry o);
    public void delete(Long code);
}
