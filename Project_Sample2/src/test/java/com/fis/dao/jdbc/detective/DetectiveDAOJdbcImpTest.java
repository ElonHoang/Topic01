package com.fis.dao.jdbc.detective;

import com.fis.core.model.Detective;
import com.fis.core.model.enums.EmployeeStatus;
import com.fis.core.model.enums.Rank;
import com.fis.dao.jdbc.person.PersonDAO;
import com.fis.dao.jdbc.person.PersonDAOJdbcImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DetectiveDAOJdbcImpTest {

    @Test
    public void testGetDetective() {
        DetectiveDAO dev = new DetectiveDAOJdbcImp();

        List<Detective> de = dev.getAll();

        assertEquals(3,de.size());

        //System.out.println(dev.getAll());

    }

    @Test
    public void testAddDetective(){
        DetectiveDAO d = new DetectiveDAOJdbcImp();
        PersonDAO p = new PersonDAOJdbcImp();
         Detective det = new Detective(3L, 002, p.getPersonById(1L), "ttTtt", Rank.CHEF_INSPECTOR, true, EmployeeStatus.UNDER_INVESGATION);

         d.add(det);
         long lo = det.getId();

         assertEquals(3L,lo);

    }

    @Test
    void getDetectiveById() {
        DetectiveDAO d = new DetectiveDAOJdbcImp();

        Detective de = d.getDetectiveById(1L);

        assertEquals(2L, de.getId());
    }

    @Test
    public void testUpdateDetective(){
        DetectiveDAO d = new DetectiveDAOJdbcImp();
        PersonDAO p = new PersonDAOJdbcImp();
        Detective det = new Detective(3L, 002, p.getPersonById(1L), "tArtt", Rank.INSPECTOR, false, EmployeeStatus.SUPENDED);

        d.update(det);
        int verson = det.getVersion();

        assertEquals(002, verson);
    }

    @Test
    public void testDeleteDetective(){
        DetectiveDAO d = new DetectiveDAOJdbcImp();

        d.delete(5l);

        assertNotEquals(5L,d.getAll().size());
    }
}