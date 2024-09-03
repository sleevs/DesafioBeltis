package br.com.jsn.desafio.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "accout_email")
    private String accountEmail;

    @Column(name = "account_phone")
    private String accountPhone;

    @Column(name = "account_document")
    private String accountDocument;


    public Account(){}

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public String getAccountDocument() {
        return accountDocument;
    }

    public void setAccountDocument(String accountDocument) {
        this.accountDocument = accountDocument;
    }

    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", accountName=" + accountName + ", accountEmail=" + accountEmail
                + ", accountPhone=" + accountPhone + ", accountDocument=" + accountDocument + ", getAccountId()="
                + getAccountId() + ", getAccountName()=" + getAccountName() + ", getAccountEmail()=" + getAccountEmail()
                + ", getAccountPhone()=" + getAccountPhone() + ", getAccountDocument()=" + getAccountDocument()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }

    

}