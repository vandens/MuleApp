
package com.my.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
//import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Vandens mc Maddens
 */
//@Entity
@Table(name="T_PAYMENT")
public class PaymentObject implements Serializable{
    
    
    @Column(name="PAY_NUMBER",unique=true,nullable=false,length=17)
    private String pay_number;
    @Column(name="PAY_SUBJECT",length=128)
    private String pay_subject;
    @Column(name="CHANNEL_ID",length=35)
    private String channel_id;
    @Column(name="CUSTOMER_ID",length=12)
    private String customer_id;
    @Column(name="USER_ID",length=12)
    private String user_id;
    @Column(name="FEATURE_ID",length=35)
    private String feature_id;
    @Column(name="PAY_EFDATE")
    private Date pay_efdate;
    @Column(name="PAY_TYPE", length=1)
    private Integer pay_type;
    @Column(name="PAY_CCY", length=3)
    private String pay_ccy;
    @Column(name="PAY_AMOUNT",scale=2,precision=17)
    private BigDecimal pay_amount;
    @Column(name="PAY_DESC")
    private String pay_desc;
    @Column(name="PAY_MESSAGE", length=160)
    private String pay_message;
    @Column(name="PAY_ADD_MESSAGE", length=160)
    private String pay_add_message;
    @Column(name="pay_status", length=1)
    private Integer pay_status;
    @Column(name="PAY_SYNC", length=1)
    private Integer pay_sync;
    @Column(name="PAY_ADDBY", length=35)
    private String pay_addby;
    @Column(name="PAY_ADDTIME")
    private String pay_addtime;
    @Column(name="PAY_UPDATEBY", length=35)
    private String pay_updateby;
    @Column(name="PAY_UPDATETIME")
    private String pay_updatetime;
    @Column(name="UID", length=50)
    private String uid;

   
    public void set_pay_number      (String param)  { this.pay_number       = param; }
    public void set_pay_subject     (String param)  { this.pay_subject      = param; }
    public void set_channel_id      (String param)  { this.channel_id       = param; }
    public void set_customer_id     (String param)  { this.customer_id      = param; }
    public void set_user_id         (String param)  { this.user_id          = param; }
    public void set_feature_id      (String param)  { this.feature_id       = param; }
    public void set_pay_efdate      (Date param)    { this.pay_efdate       = param; }
    public void set_pay_type        (Integer param) { this.pay_type         = param; }
    public void set_pay_ccy         (String param)  { this.pay_ccy          = param; }
    public void set_pay_amount      (BigDecimal param){ this.pay_amount     = param; }
    public void set_pay_desc        (String param)  { this.pay_desc         = param; }
    public void set_pay_message     (String param)  { this.pay_message      = param; }
    public void set_pay_add_message (String param)  { this.pay_add_message  = param; }
    public void set_pay_status      (Integer param) { this.pay_status       = param; }
    public void set_pay_sync        (Integer param) { this.pay_sync         = param; }
    public void set_pay_addby       (String param)  { this.pay_addby        = param; }
    public void set_pay_addtime     (String param)  { this.pay_addtime      = param; }
    public void set_pay_updateby    (String param)  { this.pay_updateby     = param; }
    public void set_pay_updatetime  (String param)  { this.pay_updatetime   = param; }
    public void set_uid             (String param)  { this.uid              = param; }

    public String get_pay_number	(){ return pay_number;}
    public String get_pay_subject	(){ return pay_subject;}
    public String get_channel_id	(){ return channel_id;}
    public String get_customer_id	(){ return customer_id;}
    public String get_user_id           (){ return user_id;}
    public String get_feature_id	(){ return feature_id;}
    public Date get_pay_efdate          (){ return pay_efdate;}
    public Integer get_pay_type         (){ return pay_type;}
    public String get_pay_ccy           (){ return pay_ccy;}
    public BigDecimal get_pay_amount	(){ return pay_amount;}
    public String get_pay_desc          (){ return pay_desc;}
    public String get_pay_message	(){ return pay_message;}
    public String get_pay_add_message	(){ return pay_add_message;}
    public Integer get_pay_status	(){ return pay_status;}
    public Integer get_pay_sync         (){ return pay_sync;}
    public String get_pay_addby         (){ return pay_addby;}
    public String get_pay_addtime	(){ return pay_addtime;}
    public String get_pay_updateby	(){ return pay_updateby;}
    public String get_pay_updatetime	(){ return pay_updatetime;}
    public String get_uid               (){ return uid;}

   
}
