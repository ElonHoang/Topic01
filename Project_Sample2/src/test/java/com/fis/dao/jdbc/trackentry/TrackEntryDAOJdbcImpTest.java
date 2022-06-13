package com.fis.dao.jdbc.trackentry;

import com.fis.core.model.TrackEntry;
import com.fis.core.model.enums.TrackAction;
import com.fis.dao.jdbc.detective.DetectiveDAO;
import com.fis.dao.jdbc.detective.DetectiveDAOJdbcImp;
import com.fis.dao.jdbc.evidence.EvidenceDAO;
import com.fis.dao.jdbc.evidence.EvidenceDAOJdbcImp;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrackEntryDAOJdbcImpTest {

    @Test
    public void testAddTrackEntry(){
        EvidenceDAO e = new EvidenceDAOJdbcImp();
        DetectiveDAO d = new DetectiveDAOJdbcImp();
        TrackEntryDAO te = new TrackEntryDAOJdbcImp();
        TrackEntry track = new TrackEntry(4l,0021,LocalDateTime.now(), e.getEvidenceById(1l), d.getDetectiveById(1l), TrackAction.RETRIEVED, "ABCNAHNJOWO");

        te.add(track);

        long id = track.getId();

        assertEquals(4L,id);
    }

    @Test
    public void testAllTrackEntries(){
        TrackEntryDAO te = new TrackEntryDAOJdbcImp();

        List<TrackEntry> list = te.getAll();

        assertEquals(3,list.size());

    }

    @Test
    void getTrackEntryById() {
        TrackEntryDAO te = new TrackEntryDAOJdbcImp();

        TrackEntry tr = te.getTrackEntryById(1L);

        assertEquals(1,tr.getId());
    }

    @Test
    void update() {
        EvidenceDAO e = new EvidenceDAOJdbcImp();
        DetectiveDAO d = new DetectiveDAOJdbcImp();
        TrackEntryDAO te = new TrackEntryDAOJdbcImp();
        TrackEntry track = new TrackEntry(4l,0021,LocalDateTime.now(), e.getEvidenceById(2l), d.getDetectiveById(2l), TrackAction.RETRIEVED, "ABCNAHNJOWO");

        te.update(track);
        int verion = track.getVersion();

        assertEquals(0021,verion);
    }

    @Test
    public void testDeleteTrackEntry(){

        TrackEntryDAO te = new TrackEntryDAOJdbcImp();

        te.delete(3L);

        assertNotEquals(3L,te.getTrackEntryById(3L));
    }
}