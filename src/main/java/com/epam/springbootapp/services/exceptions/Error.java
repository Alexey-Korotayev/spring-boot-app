package com.epam.springbootapp.services.exceptions;

public enum Error {
    NOT_AUTHORIZED(4010, "Not Authorized"),
    FORBIDDEN(4030, "Forbidden"),
    NOT_FOUND(4040, "Not Found"),
    SERVER_ERROR(5001, "Server error during operation"),
    ID_ERROR(4050, "Id should not be specified"),
    NULLID_ERROR(4051, "Id have to be specified"),
    OTHER_ERROR(5002, "Error.");

    private int code = 0;
    private String description = "";

    private Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
