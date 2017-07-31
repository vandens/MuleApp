
package com.my.Models;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="T_INTERFACE_LOG")
public class ModelInterfaceLog implements Serializable{
     @Id @GeneratedValue
     @Column(name="AUTO", length =100)
     private Integer auto;
     @Column(name="UID", length =50)
     private String uid;
     @Column(name="LOG_DATE", length =0)
     private Date log_date;
     @Column(name="PAY_NUMBER", length =17)
     private String pay_number;
     @Column(name="FEATURE_ID", length =35)
     private String feature_id;
     @Column(name="FUNCTION_NAME", length =50)
     private String function_name;
     @Column(name="RAW_REQUEST", length =0)
     private String raw_request;
     @Column(name="RAW_RESPONSE", length =0)
     private String raw_response;
     @Column(name="ERROR_CODE", length =10)
     private String error_code;
     @Column(name="ERROR_DESC", length =0)
     private String error_desc;
     @Column(name="SEND_TIME", length =0)
     private String send_time;
     @Column(name="RESPONSE_TIME", length =0)
     private String response_time;

    public void set_auto            (Integer param) { this.auto         = param; }
    public void set_uid             (String param)  { this.uid          = param; }
    public void set_log_date        (Date param)    { this.log_date	= param; }
    public void set_pay_number      (String param)  { this.pay_number	= param; }
    public void set_feature_id      (String param)  { this.feature_id	= param; }
    public void set_function_name   (String param)  { this.function_name= param; }
    public void set_raw_request     (String param)  { this.raw_request	= param; }
    public void set_raw_response    (String param)  { this.raw_response	= param; }
    public void set_error_code      (String param)  { this.error_code	= param; }
    public void set_error_desc      (String param)  { this.error_desc	= param; }
    public void set_send_time       (String param)  { this.send_time	= param; }
    public void set_response_time   (String param)  { this.response_time= param; }

    public Integer get_auto           ()  { return auto         ; }
    public String get_uid             ()  { return uid          ; }
    public Date get_log_date          ()  { return log_date	; }
    public String get_pay_number      ()  { return pay_number	; }
    public String get_feature_id      ()  { return feature_id	; }
    public String get_function_name   ()  { return function_name; }
    public String get_raw_request     ()  { return raw_request	; }
    public String get_raw_response    ()  { return raw_response	; }
    public String get_error_code      ()  { return error_code	; }
    public String get_error_desc      ()  { return error_desc	; }
    public String get_send_time       ()  { return send_time	; }
    public String get_response_time   ()  { return response_time; }
}
