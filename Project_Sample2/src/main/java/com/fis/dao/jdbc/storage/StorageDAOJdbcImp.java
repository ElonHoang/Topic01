package com.fis.dao.jdbc.storage;

import com.fis.core.model.Evidence;
import com.fis.core.model.Storage;
import com.fis.dao.jdbc.evidence.EvidenceDAO;
import com.fis.dao.jdbc.evidence.EvidenceDAOJdbcImp;
import com.fis.dao.jdbcUlti.DBMapper;
import com.fis.dao.jdbcUlti.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StorageDAOJdbcImp implements StorageDAO{
    Logger logger = LoggerFactory.getLogger(StorageDAOJdbcImp.class);
    @Override
    public void add(Storage o) {
        String sql = "INSERT INTO storage(`id`,`version`, `name`, `location`) " +
                " VALUES (? ,?, ?, ?)";
        try (Connection con = Database.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setLong(1, Long.valueOf(o.getId().toString()));
            stmt.setInt(2, o.getVersion());
            stmt.setString(3, o.getName());
            stmt.setString(4, o.getLocation());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 0) {
                logger.error("Insert Failed");
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<Storage> getAll() {
        List<Storage> storages = new ArrayList<>();
        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `storage`");
            ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()){
                Storage storage = DBMapper.getStorage(rs);
                storages.add(storage);
            }

        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return storages;
    }

    @Override
    public Storage getStorageById(long id) {
        Storage storage = new Storage();
        try(Connection con = Database.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM `storage` WHERE `id` = ?");){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                storage = DBMapper.getStorage(rs);
                return storage;
            }
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public Storage update(Storage o) {
        String sql = "UPDATE `storage` SET " +
                "`version` = ?, " +
                "`name` = ?, " +
                "`location` = ? " +
                "WHERE `id` = ?";
        try(Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setInt(1, o.getVersion());
            stmt.setString(2, o.getName());
            stmt.setString(3, o.getLocation());
            stmt.setLong(4, o.getId());
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
        String sql = "DELETE FROM `storage` WHERE `id` = ?";
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
