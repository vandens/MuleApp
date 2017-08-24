package com.my.Helper;

import java.io.Serializable;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.DateFormat.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class General {
    
    static String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    
    public General(){
        
    }
    
    public static class MessageID implements Serializable{
        private static final long serialVersionUID = -5577579081118070434L;
        private String messageID;
        public MessageID(String param){
            this.messageID = param;
        }
        public void setMessageID(String param){
            this.messageID = param;
        }
        public String getMessageID(){
            return messageID;
        }
    } 
    
    
    public static String explode(String row, String str, Integer i){        
        String[] exp = row.split(str);
        return exp[i];
    }
    
    public static String ref_id(int len){
        StringBuilder sb = new StringBuilder( len );
           for( int i = 0; i < len; i++ ) 
              sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
           return "C"+sb.toString().toUpperCase();
    }
    
    public static String dateToString(Date date, String format){
        
        try{            
            if(format.equals("yMd"))        format = "yyyy-MMM-dd";
            else if(format.equals("dMy"))   format = "dd MMM yyyy";
            else if(format.equals("ymd"))   format = "yyyy-MM-dd";
            else if(format.equals("dmy"))   format = "dd-MM-yyyy";
            else if(format.equals("datetime")) format = "yyyy-MM-dd HH:mm:ss";
            //else format = format;
                //format  = (format.equalsIgnoreCase("ymd")) ? "yyyy-MM-dd" : "dd-MM-yyyy";
            DateFormat df = new SimpleDateFormat(format);
            if(date != null || !date.equals("")){
                return df.format(date);
            }else{
                return null;
            }
        }catch(Exception ex){
            System.out.println(ex.toString());               
        }
        
        return null;
    }
    
    public static Date stringToDate(String date, String format){
        try{
            
            if(format.equals("yMd"))        format = "yyyy-MMM-dd";
            else if(format.equals("dMy"))   format = "dd MMM yyyy";
            else if(format.equals("ymd"))   format = "yyyy-MM-dd";
            else if(format.equals("dmy"))   format = "dd-MM-yyyy";
            
            DateFormat formatter = new SimpleDateFormat(format); 
            if(date != null || !date.equals("")){
                return (Date) formatter.parse(date);
            }else
                return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    public static String change_str_format(String str, String from, String to){
        
        
        return null;
    }
    
    public static String change_date_format(String str, String from, String to) throws ParseException{
        
        Date temp = stringToDate(str,from);
        String string = dateToString(temp,to);
        return string;
    }
    
    public static String money_format(String amount){
        double indouble = Double.parseDouble(amount);
        String money = String.format("%,.2f", indouble);          
        return money;
    }  
    
    public static String FixString(String str, int length, String type) throws Exception
    { 
        String padString = "";
        if(type.substring(0,1).equalsIgnoreCase("L") && type.substring(2,3).equalsIgnoreCase("Z")){
            padString = StringUtils.leftPad(str, length, "0");
        }else if(type.substring(0,1).equalsIgnoreCase("L") && type.substring(2,3).equalsIgnoreCase("S")){
            padString = StringUtils.leftPad(str, length, " ");
        }else if(type.substring(0,1).equalsIgnoreCase("R") && type.substring(2,3).equalsIgnoreCase("Z")){
            padString = StringUtils.rightPad(str, length, "0");
        }else if(type.substring(0,1).equalsIgnoreCase("R") && type.substring(2,3).equalsIgnoreCase("S")){
            padString = StringUtils.rightPad(str, length, " ");
        }
        return padString;
    }
    
    public static String ObjectLoger(Object obj){
        ReflectionToStringBuilder builder;
        builder = new ReflectionToStringBuilder(
                obj, ToStringStyle.MULTI_LINE_STYLE) {
                    
                    @Override
                    public ToStringBuilder append(String fieldName, Object obj) {
                        try {
                            return super.append(FixString(fieldName,30,"RPS"), obj); //To change body of generated methods, choose Tools | Templates.
                        } catch (Exception ex) {
                            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        return null;
                    }
                };

        return builder.toString();

    }
    
}