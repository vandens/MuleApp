
package com.my.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TP32447
 */

@Entity
@Table(name="T_SYNC_LOG")
public class ModelSyncLog implements Serializable{
    
     @Id @GeneratedValue
     @Column(name="AUTO", length=100)
     private Integer auto;
     @Column(name="UID", length=50)
     private String uid;
     @Column(name="PAY_NUMBER", length=17)
     private String pay_number;
     @Column(name="FEATURE_ID", length=35)
     private String feature_id;
     @Column(name="FIRST_REQUEST", length=0)
     private String first_request;
     @Column(name="LAST_RESPONSE", length=0)
     private String last_response;
     @Column(name="SYNC_STATUS", length=2)
     private Integer sync_status;

    public void set_auto            (Integer param) { this.auto         = param; }
    public void set_uid             (String param)  { this.uid          = param; }
    public void set_pay_number      (String param)  { this.pay_number	= param; }
    public void set_feature_id      (String param)  { this.feature_id	= param; }
    public void set_first_request   (String param)  { this.first_request= param; }
    public void set_last_response   (String param)  { this.last_response= param; }
    public void set_sync_status     (Integer param) { this.sync_status	= param; }

    public Integer get_auto           (){ return auto; }
    public String get_uid             (){ return uid ; }
    public String get_pay_number      (){ return pay_number; }
    public String get_feature_id      (){ return feature_id; }
    public String get_first_request   (){ return first_request; }
    public String get_last_response   (){ return last_response; }
    public Integer get_sync_status    (){ return sync_status; }

}
