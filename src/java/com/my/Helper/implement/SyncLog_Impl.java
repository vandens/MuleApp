
package com.my.Helper.implement;

import com.my.Helper.dao.SyncLogDAO;
import com.my.Helper.interfaces.SyncLog_Iface;
import com.my.Models.ModelSyncLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TP32447
 */
@Service(value="MasterServices")
@Transactional(readOnly=true)
public class SyncLog_Impl implements SyncLog_Iface{

    @Autowired private SyncLogDAO syncLogDao;
    
    
    @Transactional(readOnly=false)
    @Override
    public ModelSyncLog insert(ModelSyncLog data) {
        return syncLogDao.save(data);
    }
}
