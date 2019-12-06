package com.bridgelabz.addressbook;

public class CustomException extends Exception{

    ExceptionType type;
    private String message;
    enum ExceptionType {
          WRONG_FILE_TYPE,NO_SUCH_FILE, WRONG_DATA_FORMAT
    }
    public CustomException(String message) {
        super(message);

    }

    public CustomException(String message, ExceptionType type) {
        this.message = message;
        this.type = type;
    }

    public CustomException(String message, String message1, ExceptionType type) {
        super(message);
        this.message = message1;
        this.type = type;
    }

    public CustomException(String message, Throwable cause, String message1, ExceptionType type) {
        super(message, cause);
        this.message = message1;
        this.type = type;
    }

    public CustomException(Throwable cause, String message, ExceptionType type) {
        super(cause);
        this.message = message;
        this.type = type;
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, ExceptionType type) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
        this.type = type;
    }


}
