
package com.my.Models;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 *
 * @author TP32447
 */
@Table(name="M_USER")
public class ModelUser {
    
    @Column(name="USER_ID", length=35)          private	String	user_id;
    @Column(name="USER_FULLNAME", length=100)	private	String	user_fullname;
    @Column(name="USER_PASSWORD", length=225)	private	String	user_password;
    @Column(name="USER_STATUS", length=11)	private	Integer	user_status;
    @Column(name="USER_ISLOGIN", length=1)	private	Integer	user_islogin;

    public void set_user_id         (String param){ this.user_id	 = param; }
    public void set_user_fullname   (String param){ this.user_fullname	 = param; }
    public void set_user_password   (String param){ this.user_password	 = param; }
    public void set_user_status     (Integer param){ this.user_status	 = param; }
    public void set_user_islogin    (Integer param){ this.user_islogin	 = param; }

    public String get_user_id         (){ return user_id; }
    public String get_user_fullname   (){ return user_fullname; }
    public String get_user_password   (){ return user_password; }
    public Integer get_user_status    (){ return user_status; }
    public Integer get_user_islogin   (){ return user_islogin; }
}
