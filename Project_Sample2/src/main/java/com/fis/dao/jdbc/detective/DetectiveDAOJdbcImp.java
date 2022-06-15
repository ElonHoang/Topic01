package com.fis.dao.jdbc.detective;

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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetectiveDAOJdbcImp implements DetectiveDAO {
    Logger logger = LoggerFactory.getLogger(DetectiveDAOJdbcImp.class);

    @Override
    public void add(Detective o) {
        String sql = "INSERT INTO detective(`id`, `version`, `personId`, `badgeNumber`, `rank`, `armed`, `status`) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {

            stmt.setLong(1, o.getId());
            stmt.setInt(2, o.getVersion());
            stmt.setLong(3, o.getPerson().getId());
            stmt.setString(4, o.getBadgeNumber());
            stmt.setString(5, o.getRank().toString());
            stmt.setBoolean(6, o.isArmed());
            stmt.setString(7, o.getStatus().toString());
            stmt.executeUpdate();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }


    @Override
    public List<Detective> getAll() {
        List<Detective> detectiveList = new ArrayList<>();
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM detective");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Detective detective = DBMapper.getDetective(rs);
                if (detective != null) detectiveList.add(detective);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return detectiveList;


    }

    @Override
    public Detective getDetectiveById(long id) {
        Detective det = new Detective();
        String sql = "SELECT * FROM detective WHERE `id` = ?";
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                det = DBMapper.getDetective(rs);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return det;
    }

    @Override
    public Detective update(Detective o) {
        String sql = "UPDATE `detective` SET " +
                "`version` = ?, " +
                "`personId` = ?, " +
                "`badgeNumber` = ?, " +
                "`rank` = ?, " +
                "`armed` = ?, " +
                "`status` = ? " +
                "WHERE `id` = ? ";
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
        ) {
            stmt.setInt(1, o.getVersion());
            stmt.setLong(2, o.getPerson().getId());
            stmt.setString(3, o.getBadgeNumber());
            stmt.setString(4, o.getRank().name());
            stmt.setBoolean(5, o.isArmed());
            stmt.setString(6, o.getStatus().name());
            stmt.setLong(7, o.getId());
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
        String sql = "DELETE FROM `detective` WHERE `id` = ?";
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
