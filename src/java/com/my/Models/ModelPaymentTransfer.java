
package com.my.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author TP32447
 */
//@Entity
@Table(name="T_PAYMENT_TRANSFER")
public class ModelPaymentTransfer implements Serializable{
    
    @Column(name="TRANSFER_ID", length=25) 
    private String transfer_id;
    @Column(name="PAY_NUMBER", length=17) 
    private String pay_number;
    @Column(name="SOURCE_NO", length=19) 
    private String source_no;
    @Column(name="SOURCE_CCY", length=3) 
    private String source_ccy;
    @Column(name="SOURCE_NAME", length=128) 
    private String source_name;
    @Column(name="SOURCE_ALIAS", length=128) 
    private String source_alias;
    @Column(name="BENEFICIARY_NO", length=19) 
    private String beneficiary_no;
    @Column(name="BENEFICIARY_CCY", length=3) 
    private String beneficiary_ccy;
    @Column(name="BENEFICIARY_NAME", length=128) 
    private String beneficiary_name;
    @Column(name="BENEFICIARY_ALIAS", length=128) 
    private String beneficiary_alias;
    @Column(name="BENEFICIARY_EMAIL", length=128) 
    private String beneficiary_email;
    @Column(name="BENEFICIARY_CITIZENSHIP", length=2) 
    private String beneficiary_citizenship;
    @Column(name="BENEFICIARY_CITIZENSHIP_COUNTRY", length=2) 
    private String beneficiary_citizenship_country;
    @Column(name="BENEFICIARY_ADDRESS", length=128) 
    private String beneficiary_address;
    @Column(name="BENEFICIARY_ADDRESS2", length=128) 
    private String beneficiary_address2;
    @Column(name="BENEFICIARY_ADDRESS3", length=128) 
    private String beneficiary_address3;
    @Column(name="SWIFT_CODE", length=15) 
    private String swift_code;
    @Column(name="CLR_CODE", length=7) 
    private String clr_code;
    @Column(name="ORG_DIR", length=10) 
    private String org_dir;
    @Column(name="BENEFICIARY_BANK_NAME", length=105) 
    private String beneficiary_bank_name;
    @Column(name="BENEFICIARY_BANK_ADDRESS1", length=35) 
    private String beneficiary_bank_address1;
    @Column(name="BENEFICIARY_BANK_ADDRESS2", length=140) 
    private String beneficiary_bank_address2;
    @Column(name="BENEFICIARY_BANK_ADDRESS3", length=35) 
    private String beneficiary_bank_address3;
    @Column(name="BENEFICIARY_BANK_CITY", length=35) 
    private String beneficiary_bank_city;
    @Column(name="BENEFICIARY_BANK_BRANCH", length=128) 
    private String beneficiary_bank_branch;
    @Column(name="BENEFICIARY_BANK_COUNTRY", length=2) 
    private String beneficiary_bank_country;
    @Column(name="BENEFICIARY_DOM_TYPE", length=2) 
    private String beneficiary_dom_type;
    @Column(name="BENEFICIARY_TRX_TYPE", length=2) 
    private String beneficiary_trx_type;
    @Column(name="NOSTRO_CODE", length=11) 
    private String nostro_code;
    @Column(name="NOSTRO_NAME", length=50) 
    private String nostro_name;
    @Column(name="LLD_CODE", length=0) 
    private String lld_code;
    @Column(name="LLD_DESC", length=0) 
    private String lld_desc;
    @Column(name="EFT_STATUS", length=11) 
    private Integer eft_status;
    @Column(name="EFT_BANKCODE", length=2) 
    private String eft_bankcode;
    @Column(name="EFT_BANKRESPONSE", length=50) 
    private String eft_bankresponse;
    @Column(name="TRANSFER_AMOUNT", precision=17,scale=2,nullable=false)
    private BigDecimal transfer_amount;
    @Column(name="TRANSFER_MESSAGE", length=128) 
    private String transfer_message;
    @Column(name="TRANSFER_ADD_MESSAGE", length=128) 
    private String transfer_add_message;
    @Column(name="TRANSFER_REFNO", length=200) 
    private String transfer_refno;
    @Column(name="TRANSFER_STATUS", length=4) 
    private Integer transfer_status;
    @Column(name="TRANSFER_TYPE", length=6) 
    private Integer transfer_type;
    @Column(name="TRANSFER_CHARGE", precision=17,scale=2,nullable=false)
    private BigDecimal transfer_charge;
    @Column(name="TRANSFER_CHARGE_TO", length=4) 
    private Integer transfer_charge_to;
    @Column(name="TRANSFER_CHARGE_STATUS", length=11) 
    private Integer transfer_charge_status;
    @Column(name="PROVISION_FEE", length=17) 
    private BigDecimal provision_fee;
    @Column(name="BANK_RESPONSE_CODE", length=5) 
    private String bank_response_code;
    @Column(name="BANK_RESPONSE_DESC", length=225) 
    private String bank_response_desc;
    @Column(name="REVERSAL_DESC", length=255) 
    private String reversal_desc;
    @Column(name="RAW_REQUEST", length=0) 
    private String raw_request;
    @Column(name="RAW_RESPONSE", length=0) 
    private String raw_response;

    public void set_transfer_id(String param)                       {this.transfer_id = param; }
    public void set_pay_number(String param)                        {this.pay_number = param; }
    public void set_source_no(String param)                         {this.source_no = param; }
    public void set_source_ccy(String param)                        {this.source_ccy = param; }
    public void set_source_name(String param)                       {this.source_name = param; }
    public void set_source_alias(String param)                      {this.source_alias = param; }
    public void set_beneficiary_no(String param)                    {this.beneficiary_no = param; }
    public void set_beneficiary_ccy(String param)                   {this.beneficiary_ccy = param; }
    public void set_beneficiary_name(String param)                  {this.beneficiary_name = param; }
    public void set_beneficiary_alias(String param)                 {this.beneficiary_alias = param; }
    public void set_beneficiary_email(String param)                 {this.beneficiary_email = param; }
    public void set_beneficiary_citizenship(String param)           {this.beneficiary_citizenship = param; }
    public void set_beneficiary_citizenship_country(String param)   {this.beneficiary_citizenship_country = param; }
    public void set_beneficiary_address(String param)               {this.beneficiary_address = param; }
    public void set_beneficiary_address2(String param)              {this.beneficiary_address2 = param; }
    public void set_beneficiary_address3(String param)              {this.beneficiary_address3 = param; }
    public void set_swift_code(String param)                        {this.swift_code = param; }
    public void set_clr_code(String param)                          {this.clr_code = param; }
    public void set_org_dir(String param)                           {this.org_dir = param; }
    public void set_beneficiary_bank_name(String param)             {this.beneficiary_bank_name = param; }
    public void set_beneficiary_bank_address1(String param)         {this.beneficiary_bank_address1 = param; }
    public void set_beneficiary_bank_address2(String param)         {this.beneficiary_bank_address2 = param; }
    public void set_beneficiary_bank_address3(String param)         {this.beneficiary_bank_address3 = param; }
    public void set_beneficiary_bank_city(String param)             {this.beneficiary_bank_city = param; }
    public void set_beneficiary_bank_branch(String param)           {this.beneficiary_bank_branch = param; }
    public void set_beneficiary_bank_country(String param)          {this.beneficiary_bank_country = param; }
    public void set_beneficiary_dom_type(String param)              {this.beneficiary_dom_type = param; }
    public void set_beneficiary_trx_type(String param)              {this.beneficiary_trx_type = param; }
    public void set_nostro_code(String param)                       {this.nostro_code = param; }
    public void set_nostro_name(String param)                       {this.nostro_name = param; }
    public void set_lld_code(String param)                          {this.lld_code = param; }
    public void set_lld_desc(String param)                          {this.lld_desc = param; }
    public void set_eft_status(Integer param)                       {this.eft_status = param; }
    public void set_eft_bankcode(String param)                      {this.eft_bankcode = param; }
    public void set_eft_bankresponse(String param)                  {this.eft_bankresponse = param; }
    public void set_transfer_amount(BigDecimal param)               {this.transfer_amount = param; }
    public void set_transfer_message(String param)                  {this.transfer_message = param; }
    public void set_transfer_add_message(String param)              {this.transfer_add_message = param; }
    public void set_transfer_refno(String param)                    {this.transfer_refno = param; }
    public void set_transfer_status(Integer param)                  {this.transfer_status = param; }
    public void set_transfer_type(Integer param)                    {this.transfer_type = param; }
    public void set_transfer_charge(BigDecimal param)               {this.transfer_charge = param; }
    public void set_transfer_charge_to(Integer param)               {this.transfer_charge_to = param; }
    public void set_transfer_charge_status(Integer param)           {this.transfer_charge_status = param; }
    public void set_provision_fee(BigDecimal param)                 {this.provision_fee = param; }
    public void set_bank_response_code(String param)                {this.bank_response_code = param; }
    public void set_bank_response_desc(String param)                {this.bank_response_desc = param; }
    public void set_reversal_desc(String param)                     {this.reversal_desc = param; }
    public void set_raw_request(String param)                       {this.raw_request = param; }
    public void set_raw_response(String param)                      {this.raw_response = param; }

    public String get_transfer_id()                       { return transfer_id; }
    public String get_pay_number()                        { return pay_number; }
    public String get_source_no()                         { return source_no; }
    public String get_source_ccy()                        { return source_ccy; }
    public String get_source_name()                       { return source_name; }
    public String get_source_alias()                      { return source_alias; }
    public String get_beneficiary_no()                    { return beneficiary_no; }
    public String get_beneficiary_ccy()                   { return beneficiary_ccy; }
    public String get_beneficiary_name()                  { return beneficiary_name; }
    public String get_beneficiary_alias()                 { return beneficiary_alias; }
    public String get_beneficiary_email()                 { return beneficiary_email; }
    public String get_beneficiary_citizenship()           { return beneficiary_citizenship; }
    public String get_beneficiary_citizenship_country()   { return beneficiary_citizenship_country; }
    public String get_beneficiary_address()               { return beneficiary_address; }
    public String get_beneficiary_address2()              { return beneficiary_address2; }
    public String get_beneficiary_address3()              { return beneficiary_address3; }
    public String get_swift_code()                        { return swift_code; }
    public String get_clr_code()                          { return clr_code; }
    public String get_org_dir()                           { return org_dir; }
    public String get_beneficiary_bank_name()             { return beneficiary_bank_name; }
    public String get_beneficiary_bank_address1()         { return beneficiary_bank_address1; }
    public String get_beneficiary_bank_address2()         { return beneficiary_bank_address2; }
    public String get_beneficiary_bank_address3()         { return beneficiary_bank_address3; }
    public String get_beneficiary_bank_city()             { return beneficiary_bank_city; }
    public String get_beneficiary_bank_branch()           { return beneficiary_bank_branch; }
    public String get_beneficiary_bank_country()          { return beneficiary_bank_country; }
    public String get_beneficiary_dom_type()              { return beneficiary_dom_type; }
    public String get_beneficiary_trx_type()              { return beneficiary_trx_type; }
    public String get_nostro_code()                       { return nostro_code; }
    public String get_nostro_name()                       { return nostro_name; }
    public String get_lld_code()                          { return lld_code; }
    public String get_lld_desc()                          { return lld_desc; }
    public Integer get_eft_status(Integer param)          { return eft_status; }
    public String get_eft_bankcode()                      { return eft_bankcode; }
    public String get_eft_bankresponse()                  { return eft_bankresponse; }
    public BigDecimal get_transfer_amount(BigDecimal param){ return transfer_amount; }
    public String get_transfer_message()                  { return transfer_message; }
    public String get_transfer_add_message()              { return transfer_add_message; }
    public String get_transfer_refno()                    { return transfer_refno; }
    public Integer get_transfer_status(Integer param)     { return transfer_status; }
    public Integer get_transfer_type(Integer param)       { return transfer_type; }
    public BigDecimal get_transfer_charge(BigDecimal param){ return transfer_charge; }
    public Integer get_transfer_charge_to(Integer param)  { return transfer_charge_to; }
    public Integer get_transfer_charge_status(Integer param){ return transfer_charge_status; }
    public BigDecimal get_provision_fee(BigDecimal param) { return provision_fee; }
    public String get_bank_response_code()                { return bank_response_code; }
    public String get_bank_response_desc()                { return bank_response_desc; }
    public String get_reversal_desc()                     { return reversal_desc; }
    public String get_raw_request()                       { return raw_request; }
    public String get_raw_response()                      { return raw_response; }



}
