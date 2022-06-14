package com.fis.dao.jdbc.storage;

import com.fis.core.model.Storage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StorageDAOJdbcImpTest {

    @Test
    public void testAddStorage(){
        StorageDAO s = new StorageDAOJdbcImp();
        Storage st = new Storage(3l, 004, "Bm", "FHN");

        s.add(st);
        long id = st.getId();

        assertEquals(3L, id);
    }


    @Test
    public void testAllStorage(){
        StorageDAO s = new StorageDAOJdbcImp();

        List<Storage> list = s.getAll();

        assertEquals(3,list.size());
    }

    @Test
    void getStorageById() {
        StorageDAO s = new StorageDAOJdbcImp();

       Storage st =  s.getStorageById(1L);

       assertEquals(1,st.getId());
    }

    @Test
    public void testUpdateStorage(){
        StorageDAO s = new StorageDAOJdbcImp();
        Storage st = new Storage(2l, 0041, "Am", "VAVN");

        s.update(st);
        long verion = st.getVersion();

        assertEquals(0041,verion);
    }

    @Test
    public void testDeleteStorage(){
        StorageDAO s = new StorageDAOJdbcImp();

        s.delete(5l);

        assertNotEquals(5L, s.getStorageById(5L));
    }
}