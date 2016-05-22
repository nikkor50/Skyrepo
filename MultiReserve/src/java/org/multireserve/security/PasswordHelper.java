/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.security;

import java.util.UUID;

import org.apache.shiro.crypto.hash.Sha512Hash;
import org.multireserve.entity.URLUser;

/**
 *
 * @author Nikkor50
 */
public class PasswordHelper {

    public static URLUser generatePassword(URLUser user) {
        byte[] passwordSalt = UUID.randomUUID().toString().getBytes();
        user.setPasswordSalt(passwordSalt);
        String passwordHash = new Sha512Hash(user.getUserpasscode(), user.getUsername() + new String(passwordSalt), 99).toString();
        user.setPasswordHash(passwordHash);
        return user;
    }
}
