package com.fis.dao.jdbc.person;

import com.fis.core.model.CriminalCase;
import com.fis.core.model.Detective;
import com.fis.core.model.Person;
import com.fis.dao.jdbc.criminal.CriminalDAOJdbcImp;
import com.fis.dao.jdbcUlti.DBMapper;
import com.fis.dao.jdbcUlti.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOJdbcImp implements PersonDAO{
    static Logger logger = LoggerFactory.getLogger(PersonDAOJdbcImp.class);
    @Override
    public void add(Person o) {
        String sql = "INSERT INTO person(`id`,`version`, `userName`, `firstName`, `lastName`, `passWord`, `hiringDate`) " +
                " VALUES (? ,?, ?, ?, ?, ?, ?)";
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setLong(1, Long.valueOf(o.getId().toString()));
            stmt.setInt(2, o.getVersion());
            stmt.setString(3, o.getUserName());
            stmt.setString(4, o.getFirstName());
            stmt.setString(5, o.getLastName());
            stmt.setString(6, o.getPassWord());
            stmt.setDate(7, java.sql.Date.valueOf(o.getHiringDate().toLocalDate()));

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 0) {
                logger.error("Insert Failed");
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Person getPersonById(long id) {
        Person p = new Person();
        String sql = "SELECT * FROM person WHERE `id` = ?";
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p = DBMapper.getPerson(rs);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return p;
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT * FROM person" ;
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                Person p = DBMapper.getPerson(rs);
                if (p != null) personList.add(p);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return personList;
    }

    @Override
    public Person update(Person o) {
        String sql = "UPDATE `Person` SET " +
                "`version` = ?, " +
                "`userName` = ?, " +
                "`firstName` = ?, " +
                "`lastName` = ?, " +
                "`passWord` = ?, " +
                "`hiringDate` = ? " +
                "WHERE `id` = ?";
        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, o.getVersion());
            stmt.setString(2, o.getUserName());
            stmt.setString(3, o.getFirstName());
            stmt.setString(4, o.getLastName());
            stmt.setString(5, o.getPassWord());
            stmt.setDate(6, java.sql.Date.valueOf(o.getHiringDate().toLocalDate()));
            stmt.setLong(7, o.getId());
            int update = stmt.executeUpdate();
            if(update == 0){
                logger.error("Update Failed");
                return null;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
        return o;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE  FROM `person` "
                + "WHERE `id` = ? "
                + "LIMIT 1";
        try (
                Connection connect = Database.getConnection();
                PreparedStatement stmt = connect.prepareStatement(sql);) {
            stmt.setLong(1, id);
            int rowDeleted = stmt.executeUpdate();
            if (rowDeleted == 0) {
                logger.error("Delete Failed !");
            }
        } catch (Exception e) {
            logger.error("Delete Failed !");
        }
    }
}
