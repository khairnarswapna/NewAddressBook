package com.bridgelabz.addressbook;

public class CustomException extends Exception{

    public ExceptionType type;
    private String message;

    public enum ExceptionType {
        PERSON_NOT_FOUND, DADA_NOT_SAVED, ADDRESSBOOK_DOESNOT_EXIST,IO_EXCEPTION, NO_SUCH_FIELD, CANNOT_ACCESS_FILE_DATA, FILE_NOT_FOUND
    }
    public CustomException(ExceptionType type,String message) {
        super(message);
        this.type=type;
    }
    public CustomException(String message) {
        super(message);

    }
    public CustomException(String message, ExceptionType type) {
        this.message = message;
        this.type = type;
    }

}
