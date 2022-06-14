package com.fis.dao.jdbc.person;

import com.fis.core.model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOJdbcImpTest {

    @Test
    public void testAddPerson(){
        PersonDAO p = new PersonDAOJdbcImp();
        Person s = new Person(4L, 003, "Hoang","Nguyen","Viet","12345", LocalDateTime.now());

        p.add(s);

        assertEquals(4,s.getId());
    }


    @Test
    void getPersonById() {
        PersonDAO p = new PersonDAOJdbcImp();

        Person s = p.getPersonById(1L);

        assertEquals(1,s.getId());
    }

    @Test
    public void testAllPerson(){
        PersonDAO p = new PersonDAOJdbcImp();

        List<Person> list = p.getAll();

        assertEquals(3,list.size());
    }

    @Test
    public void testUpdatePerson(){
        PersonDAO p = new PersonDAOJdbcImp();
        Person s = new Person(3L, 002, "Hoanf","Nguyef","Vief","AAA3970", LocalDateTime.now());

        p.update(s);
        int version = s.getVersion();

        assertEquals(002,version);

    }

    @Test
    public void testDeletePerson(){
        PersonDAO p = new PersonDAOJdbcImp();

        p.delete(4L);

        assertNotEquals(4,p.getPersonById(4));

    }
}