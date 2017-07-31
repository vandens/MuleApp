/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.Helper.interfaces;

import com.my.Models.ModelSyncLog;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author TP32447
 */
@Service("SyncLog_Iface")
public interface SyncLog_Iface {    
    public ModelSyncLog insert (ModelSyncLog data);
    /*
    public ModelSyncLog update (Integer key, ModelSyncLog data);
    public ModelSyncLog detail (Integer key);
    public List<ModelSyncLog> select (Integer key);
    public List<ModelSyncLog> find (HashMap filter, Integer offset, Integer limit, String OrderField, String Order);
    */
}
