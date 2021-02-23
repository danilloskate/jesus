package com.mockaroo.exeptions;



public class FailCommunicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FailCommunicationException(String message) {
        super(message);
    }

    public FailCommunicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailCommunicationException(Throwable cause) {
        super(cause);
    }
}

