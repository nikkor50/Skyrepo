/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.entity;

import java.util.Date;
import org.multireserve.common.BaseEntity;

/**
 *
 * @author Nikkor50
 */
public class URLUser extends BaseEntity {

    private static final long serialVersionUID = 57212890345839147L;

    private int userid;
    private String username;
    private String userpasscode;
    private String passwordHash;
    private byte[] passwordSalt;
    private String mailbox;
    private int groupid;
    private Date lastLogin;
    private Date expirationDate;
    private String storedPassword;

    public boolean isPasswordExpired() {
        if (expirationDate == null) {
            return true;
        }
        return (new Date()).after(expirationDate);
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpasscode() {
        return userpasscode;
    }

    public void setUserpasscode(String userpasscode) {
        this.userpasscode = userpasscode;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public byte[] getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getStoredPassword() {
        return storedPassword;
    }

    public void setStoredPassword(String storedPassword) {
        this.storedPassword = storedPassword;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}
