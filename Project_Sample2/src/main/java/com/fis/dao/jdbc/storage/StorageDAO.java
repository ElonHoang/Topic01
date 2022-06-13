package com.fis.dao.jdbc.storage;

import com.fis.core.model.Evidence;
import com.fis.core.model.Storage;

import java.util.List;

public interface StorageDAO {
    public void add(Storage o);
    public List<Storage> getAll();
    public Storage getStorageById(long id);
    public Storage update(Storage o);
    public void delete(Long code);
}
