package com.fis.dao.jdbcUlti;

import com.fis.core.model.*;
import com.fis.core.model.enums.*;
import com.fis.dao.jdbc.criminal.CriminalDAO;
import com.fis.dao.jdbc.criminal.CriminalDAOJdbcImp;
import com.fis.dao.jdbc.detective.DetectiveDAO;
import com.fis.dao.jdbc.detective.DetectiveDAOJdbcImp;
import com.fis.dao.jdbc.evidence.EvidenceDAO;
import com.fis.dao.jdbc.evidence.EvidenceDAOJdbcImp;
import com.fis.dao.jdbc.person.PersonDAO;
import com.fis.dao.jdbc.person.PersonDAOJdbcImp;
import com.fis.dao.jdbc.storage.StorageDAO;
import com.fis.dao.jdbc.storage.StorageDAOJdbcImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DBMapper {
    public static final Logger logger = LoggerFactory.getLogger(DBMapper.class);

    public static CriminalCase getCriminalCase(ResultSet criminalCase){
        DetectiveDAO detectiveDAO = new DetectiveDAOJdbcImp();
        try{
            CriminalCase cri = new CriminalCase();
            cri.setId(criminalCase.getLong("id"));
            cri.setVersion(criminalCase.getInt("version"));
            cri.setNumber(criminalCase.getString("number"));
            cri.setType(CaseType.valueOf(criminalCase.getString("type")));
            cri.setShortDescription(criminalCase.getString("shortDescription"));
            cri.setDetailedDescription(criminalCase.getString("detailedDescription"));
            cri.setStatus(CaseStatus.valueOf(criminalCase.getString("status")));
            cri.setNotes(criminalCase.getString("note"));
            cri.setLeadInvestigator(detectiveDAO.getDetectiveById(criminalCase.getLong("leadDetective")));
            return cri;
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;

    }

    public static Person getPerson(ResultSet person){
        try{
            Person per = new Person();
            per.setId(person.getLong("id"));
            per.setVersion(person.getInt("version"));
            per.setUserName(person.getString("userName"));
            per.setFirstName(person.getString("firstName"));
            per.setLastName(person.getString("lastName"));
            per.setPassWord(person.getString("passWord"));
            per.setHiringDate(Instant.ofEpochMilli(person.getDate("hiringDate").getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime());

            return per;
        }catch(Exception e){
            logger.error(e.getMessage() + "at getPerson()");
        }
        return null;
    }
    public static Detective getDetective(ResultSet detective){
        DetectiveDAO detectiveDAO = new DetectiveDAOJdbcImp();
        PersonDAO personDAO = new PersonDAOJdbcImp();
        try{
            Detective det = new Detective();
            det.setId(detective.getLong("id"));
            det.setVersion(detective.getInt("version"));
            det.setPerson(personDAO.getPersonById(detective.getLong("personId")));
            det.setBadgeNumber(detective.getString("badgeNumber"));
            det.setRank(Rank.valueOf(detective.getString("rank")));
            det.setArmed(Boolean.parseBoolean(detective.getString("armed")));
            det.setStatus(EmployeeStatus.valueOf(detective.getString("status")));
            return det;
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public static Evidence getEvidence(ResultSet evidences){
        CriminalDAO criminalDAO = new CriminalDAOJdbcImp();
        StorageDAO st = new StorageDAOJdbcImp();
        try{
            Evidence evi = new Evidence();
            evi.setId(evidences.getLong("id"));
            evi.setVersion(evidences.getInt("version"));
            evi.setCriminalCase(criminalDAO.getCriminalById(evidences.getLong("criminalId")));
            evi.setStorage(st.getStorageById(evidences.getLong("storageId")));
            evi.setNumber(evidences.getString("number"));
            evi.setItemName(evidences.getString("itemName"));
            evi.setNotes(evidences.getString("note"));
            evi.setArchired(evidences.getBoolean("archired"));
            return evi;
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public static Storage getStorage(ResultSet storages) {
        EvidenceDAO evidenceDAO = new EvidenceDAOJdbcImp();
        try {
            Storage storage = new Storage();
            storage.setId(storages.getLong("id"));
            storage.setVersion(storages.getInt("version"));
            storage.setName(storages.getString("name"));
            storage.setLocation(storages.getString("location"));
            return storage;
        } catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public static TrackEntry getTrackEntry(ResultSet tracks) {
        EvidenceDAO evidenceDAO = new EvidenceDAOJdbcImp();
        DetectiveDAO detectiveDAO = new DetectiveDAOJdbcImp();
        try {
            TrackEntry trackEntry = new TrackEntry();
            trackEntry.setId(tracks.getLong("id"));
            trackEntry.setVersion(tracks.getInt("version"));
            trackEntry.setDate(Instant.ofEpochMilli(tracks.getDate("date").getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime());
            trackEntry.setEvidence(evidenceDAO.getEvidenceById(tracks.getLong("evidenceId")));
            trackEntry.setDerevtive(detectiveDAO.getDetectiveById(tracks.getLong("detectiveId")));
            trackEntry.setAction(TrackAction.valueOf(tracks.getString("action")));
            trackEntry.setReason(tracks.getString("reason"));
            return trackEntry;
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }
}
