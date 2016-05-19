/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.common;

/**
 *
 * @author Nikkor50
 */
public enum Error {

    REQUIRED_VALUE(1000, "%s is a required value."),
    INVALID_VALUE(1001, "%s value is invalid");

    private final int code;
    private final String errorMessageTemplate;

    private Error(int code, String errorMessageTemplate) {
        this.code = code;
        this.errorMessageTemplate = errorMessageTemplate;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMessageTemplate() {
        return this.errorMessageTemplate;
    }
}
