package com.fis.dao.jdbc.criminal;

import com.fis.core.model.*;
import com.fis.core.model.enums.*;
import com.fis.dao.jdbc.detective.DetectiveDAO;
import com.fis.dao.jdbc.detective.DetectiveDAOJdbcImp;
import com.fis.dao.jdbc.evidence.EvidenceDAO;
import com.fis.dao.jdbc.evidence.EvidenceDAOJdbcImp;
import com.fis.dao.jdbc.person.PersonDAO;
import com.fis.dao.jdbc.person.PersonDAOJdbcImp;
import com.fis.dao.jdbc.storage.StorageDAO;
import com.fis.dao.jdbc.storage.StorageDAOJdbcImp;
import com.fis.dao.jdbc.trackentry.TrackEntryDAO;
import com.fis.dao.jdbc.trackentry.TrackEntryDAOJdbcImp;
import com.fis.dao.jdbcUlti.DBMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;


class CriminalDAOJdbcImpTest {

    @Test
    public void testGetCriminalCase() {
        CriminalDAO cri = new CriminalDAOJdbcImp();

        List<CriminalCase> c = cri.getAll();

        //System.out.println(c.toString());
        assertEquals(2,c.size());
    }




    @Test
    public void testAddCriminal(){
        CriminalDAO d = new CriminalDAOJdbcImp();
        DetectiveDAO det = new DetectiveDAOJdbcImp();
        CriminalCase c = new CriminalCase(2L,001,"003", CaseType.INFRACTION,"short","detailed", CaseStatus.CLOSED,"note",det.getDetectiveById(2L));

        d.add(c);
        long ch = c.getId();

        assertEquals(2L,ch);


    }
    @Test
    public void testUpdateCriminal(){
        CriminalDAO d = new CriminalDAOJdbcImp();
        DetectiveDAO det = new DetectiveDAOJdbcImp();
        CriminalCase c = new CriminalCase(2L,002,"043", CaseType.FENOLY,"short","detailed", CaseStatus.IN_COURT,"note",det.getDetectiveById(2L));

        d.update(c);
        int ve = c.getVersion();

        assertEquals(002,ve);
    }
    @Test
    public void testDeleteCriminal(){
        CriminalDAO c = new CriminalDAOJdbcImp();

        c.delete(5l);

        assertNotEquals(3, c.getAll().size());
    }

    @Test
    public void testGetCriminalById(){
        CriminalDAO c = new CriminalDAOJdbcImp();

        CriminalCase cr = c.getCriminalById(2L);

        assertEquals(2L,cr.getId());
    }
}