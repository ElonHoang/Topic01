package com.fis.dao.jdbc.evidence;

import com.fis.core.model.Evidence;
import com.fis.dao.jdbc.criminal.CriminalDAO;
import com.fis.dao.jdbc.criminal.CriminalDAOJdbcImp;
import com.fis.dao.jdbc.storage.StorageDAO;
import com.fis.dao.jdbc.storage.StorageDAOJdbcImp;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvidenceDAOJdbcImpTest {

    @Test
    public void testAddEvidence(){
        EvidenceDAO e = new EvidenceDAOJdbcImp();
        CriminalDAO cri = new CriminalDAOJdbcImp();
        StorageDAO st = new StorageDAOJdbcImp();
        Evidence evi = new Evidence(3L,003,cri.getCriminalById(1L),st.getStorageById(1L),"333","item3","note3",false);
        e.add(evi);
    }

    @Test
    public void testGetEvidence() {
        EvidenceDAO evi = new EvidenceDAOJdbcImp();

        List<Evidence> list = evi.getAll();
        //System.out.println(evi.getAll());
        assertEquals(3,list.size());
    }

    @Test
    void getEvidenceById() {
        EvidenceDAO e = new EvidenceDAOJdbcImp();

        Evidence ev = e.getEvidenceById(1L);

        assertEquals(1, ev.getId());
    }

    @Test
    public void testUpdateEvidence(){
        EvidenceDAO e = new EvidenceDAOJdbcImp();
        CriminalDAO cri = new CriminalDAOJdbcImp();
        StorageDAO st = new StorageDAOJdbcImp();
        Evidence evi = new Evidence(3L,020,cri.getCriminalById(2L),st.getStorageById(2L),"222L","item2","note2",false);

        e.update(evi);
        int version = evi.getVersion();

        assertEquals(020,version);
    }

    @Test
    void delete() {
        EvidenceDAO e = new EvidenceDAOJdbcImp();

        e.delete(1L);

        assertNotEquals(1,e.getEvidenceById(1L));
    }
}