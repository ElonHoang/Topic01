package com.fis.dao.jdbc.trackentry;

import com.fis.core.model.Storage;
import com.fis.core.model.TrackEntry;
import com.fis.dao.jdbc.storage.StorageDAOJdbcImp;
import com.fis.dao.jdbcUlti.DBMapper;
import com.fis.dao.jdbcUlti.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrackEntryDAOJdbcImp implements TrackEntryDAO{
    Logger logger = LoggerFactory.getLogger(TrackEntryDAOJdbcImp.class);
    @Override
    public void add(TrackEntry o) {
        String sql = "INSERT INTO trackentry(`id`,`version`, `date`, `evidenceId`, `detectiveId`, `action`, `reason`) " +
                " VALUES (? ,?, ?, ?, ?, ?, ?)";
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setLong(1, Long.valueOf(o.getId().toString()));
            stmt.setInt(2, o.getVersion());
            stmt.setDate(3, java.sql.Date.valueOf(o.getDate().toLocalDate()));
            stmt.setLong(4, o.getEvidence().getId());
            stmt.setLong(5,o.getDerevtive().getId());
            stmt.setString(6, o.getAction().name());
            stmt.setString(7, o.getReason());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 0) {
                logger.error("Insert Failed");
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<TrackEntry> getAll() {
        List<TrackEntry> trackEntries = new ArrayList<>();
        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `trackentry`");
            ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()){
                TrackEntry track = DBMapper.getTrackEntry(rs);
                trackEntries.add(track);
            }

        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return trackEntries;
    }

    @Override
    public TrackEntry getTrackEntryById(long id) {
        return null;
    }

    @Override
    public TrackEntry update(TrackEntry o) {
        String sql = "UPDATE `trackentry` SET " +
                "`version` = ?, " +
                "`date` = ?, " +
                "`evidenceId` = ?, " +
                "`detectiveId` = ?, " +
                "`action` = ?, " +
                "`reason` = ? " +
                "WHERE `id` = ?";
        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setInt(1, o.getVersion());
            stmt.setDate(2, java.sql.Date.valueOf(o.getDate().toLocalDate()));
            stmt.setLong(3, o.getEvidence().getId());
            stmt.setLong(4,o.getDerevtive().getId());
            stmt.setString(5, o.getAction().name());
            stmt.setString(6, o.getReason());
            stmt.setLong(7, o.getId());
            int update = stmt.executeUpdate();
            if(update == 0) {
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
        String sql = "DELETE FROM `trackentry` WHERE `id` = ?";
        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){
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
