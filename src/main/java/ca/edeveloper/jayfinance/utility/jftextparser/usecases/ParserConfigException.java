package ca.edeveloper.jayfinance.utility.jftextparser.usecases;

public class ParserConfigException extends Exception {
    public ParserConfigException() {
    }

    public ParserConfigException(String message) {
        super(message);
    }

    public ParserConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserConfigException(Throwable cause) {
        super(cause);
    }

    public ParserConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
