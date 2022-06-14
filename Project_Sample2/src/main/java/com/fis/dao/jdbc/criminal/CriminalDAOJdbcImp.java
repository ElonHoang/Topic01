package com.fis.dao.jdbc.criminal;

import com.fis.core.model.CriminalCase;
import com.fis.core.model.Detective;
import com.fis.core.model.Evidence;
import com.fis.dao.jdbcUlti.DBMapper;
import com.fis.dao.jdbcUlti.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CriminalDAOJdbcImp implements CriminalDAO {
    static Logger logger = LoggerFactory.getLogger(CriminalDAOJdbcImp.class);

    @Override
    public void add(CriminalCase o) {
        String sql = "INSERT INTO criminal(`id`,`version`, `number`, `type`, `shortDescription`, `detailedDescription`, `status`, `note`, `leadDetective`) " +
                " VALUES (? ,?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setLong(1, Long.valueOf(o.getId().toString()));
            stmt.setInt(2, o.getVersion());
            stmt.setString(3, o.getNumber());
            stmt.setString(4, o.getType().toString());
            stmt.setString(5, o.getShortDescription());
            stmt.setString(6, o.getDetailedDescription());
            stmt.setString(7, o.getStatus().toString());
            stmt.setString(8, o.getNotes());
            stmt.setLong(9, Long.valueOf(o.getLeadInvestigator().getId().toString()));
            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 0) {
                logger.error("Insert Failed");
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public CriminalCase getCriminalById(long id) {
        CriminalCase criminal = new CriminalCase();
        String sql = "SELECT * FROM criminal where `id` = ?";
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                criminal = DBMapper.getCriminalCase(rs);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return criminal;
    }

    @Override
    public List<CriminalCase> getAll() {
        List<CriminalCase> criminalCases = new ArrayList<>();
        String sql = "SELECT * FROM criminal" ;
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                CriminalCase criminalCase = DBMapper.getCriminalCase(rs);
                if (criminalCase != null) criminalCases.add(criminalCase);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return criminalCases;
    }

    @Override
    public CriminalCase update(CriminalCase o) {
        String sql = "UPDATE `Criminal` SET " +
                "`version` = ?, " +
                "`number` = ?, " +
                "`type` = ?, " +
                "`shortDescription` = ?, " +
                "`detailedDescription` = ?, " +
                "`status` = ?, " +
                "`note` = ?, " +
                "`leadDetective` = ? " +
                "WHERE `id` = ? ";
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {

            stmt.setInt(1, o.getVersion());
            stmt.setString(2, o.getNumber());
            stmt.setString(3, o.getType().name());
            stmt.setString(4, o.getShortDescription());
            stmt.setString(5, o.getDetailedDescription());
            stmt.setString(6, o.getStatus().name());
            stmt.setString(7, o.getNotes());
            stmt.setLong(8, o.getLeadInvestigator().getId());
            stmt.setLong(9, o.getId());
            int update = stmt.executeUpdate();
            if (update == 0) {
                logger.error("Update failed");
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
        String sql = "DELETE FROM `criminal` WHERE `id` = ?";
        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setLong(1, id);
            int delete = stmt.executeUpdate();
            if (delete == 0) {
                logger.error("Delete Failed");
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());

        }
    }
}
