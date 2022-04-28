package ir.caspco.visualization.config.exceptionhandler;

import lombok.Getter;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Getter
public class RestException extends RuntimeException {
    private Object[] args;

    public RestException(Object[] args) {
        this.args = args;
    }

    public RestException(String message) {
        super(message);
    }

    public RestException(String message, Object[] args) {
        super(message);
        this.args = args;
    }

    public RestException(String message, Throwable cause, Object[] args) {
        super(message, cause);
        this.args = args;
    }

    public RestException(Throwable cause, Object[] args) {
        super(cause);
        this.args = args;
    }

    public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Object[] args) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.args = args;
    }
}