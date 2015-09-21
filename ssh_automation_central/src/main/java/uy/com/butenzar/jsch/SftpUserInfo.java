/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.jsch;

import com.jcraft.jsch.UserInfo;

/**
 * Implements UserInfo instance in order to support SFTP connection to any machine without a key.
 */
public class SftpUserInfo implements UserInfo {

    String password = null;

    @Override
    public String getPassphrase() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String passwd) {
        password = passwd;
    }

    @Override
    public boolean promptPassphrase(String message) {
        return false;
    }

    @Override
    public boolean promptPassword(String message) {
        return false;
    }

    @Override
    public boolean promptYesNo(String message) {
        return true;
    }

    @Override
    public void showMessage(String message) {
    }
}