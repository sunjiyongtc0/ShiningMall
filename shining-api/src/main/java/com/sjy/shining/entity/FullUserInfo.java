package com.sjy.shining.entity;

import java.io.Serializable;


/**
 */
public class FullUserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    //errMsg
    private String errMsg;
    //rawData
    private String rawData;
    //userInfo
    private UserInfo userInfo;
    //encryptedData
    private String encryptedData;
    //iv
    private String iv;
    //signature
    private String signature;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}