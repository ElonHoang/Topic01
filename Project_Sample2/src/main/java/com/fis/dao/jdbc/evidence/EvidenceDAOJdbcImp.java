package com.fis.dao.jdbc.evidence;

import com.fis.core.model.Evidence;
import com.fis.dao.jdbcUlti.DBMapper;
import com.fis.dao.jdbcUlti.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EvidenceDAOJdbcImp implements  EvidenceDAO{
    Logger logger = LoggerFactory.getLogger(EvidenceDAOJdbcImp.class);
    @Override
    public void add(Evidence o) {
        String sql = "INSERT INTO `evidence` (`id`, `version`, `criminalId`, `storageId`, `number`, `itemName`, `note`, `archired`) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)
        ) {
            stmt.setLong(1, o.getId());
            stmt.setInt(2, o.getVersion());
            stmt.setLong(3, o.getCriminalCase().getId());
            stmt.setLong(4, o.getStorage().getId());
            stmt.setString(5, o.getNumber());
            stmt.setString(6, o.getItemName());
            stmt.setString(7, o.getNotes());
            stmt.setBoolean(8, o.isArchired());
            int insert = stmt.executeUpdate();
            if (insert == 0) {logger.error("Insert failed");}
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public List<Evidence> getAll() {
        List<Evidence> evidenceList = new ArrayList<>();
        String sql = "SELECT * FROM evidence";
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery ();) {
                while (rs.next()) {
                Evidence evidence = DBMapper.getEvidence(rs);
                if(evidence != null) evidenceList.add(evidence);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return evidenceList;
    }

    @Override
    public Evidence getEvidenceById(long id) {
        Evidence e;
        String sql = "SELECT * FROM evidence WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                e = DBMapper.getEvidence(rs);
                return e;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public Evidence update(Evidence o) {
        String sql = "UPDATE `evidence` SET " +
                "`version` = ?, " +
                "`criminalId` = ?, " +
                "`storageId` = ?, " +
                "`number` = ?, " +
                "`itemName` = ?, " +
                "`note` = ?, " +
                "`archired` = ? " +
                "WHERE `id` = ?";
        try(Connection con = Database.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, o.getVersion());
            stmt.setLong(2, o.getCriminalCase().getId());
            stmt.setLong(3, o.getStorage().getId());
            stmt.setString(4, o.getNumber());
            stmt.setString(5, o.getItemName());
            stmt.setString(6, o.getNotes());
            stmt.setBoolean(7, o.isArchired());
            stmt.setLong(8, o.getId());
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
        String sql = "DELETE FROM `evidence` WHERE `id` = ?";
        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setLong(1, id);
            int delete = stmt.executeUpdate();
            if (delete == 0){
                logger.error("Delete Failed");
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());

        }
    }
}
