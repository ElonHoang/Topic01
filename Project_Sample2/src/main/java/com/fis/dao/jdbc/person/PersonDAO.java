package com.fis.dao.jdbc.person;

import com.fis.core.model.CriminalCase;
import com.fis.core.model.Person;

import java.util.List;

public interface PersonDAO {
    public void add(Person o);
    public Person getPersonById(long id);
    public List<Person> getAll();
    public Person update(Person o);
    public void delete(Long code);
}
