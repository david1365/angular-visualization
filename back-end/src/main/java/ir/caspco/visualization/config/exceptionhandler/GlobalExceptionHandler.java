package ir.caspco.visualization.config.exceptionhandler;

import ir.caspco.visualization.body.components.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Messages messages;

    public GlobalExceptionHandler(Messages Messages) {
        this.messages = Messages;
    }

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgument(RestException ex, Locale locale) {
        String errorMessage = messages.getMessage(ex.getMessage(), ex.getArgs(), locale);
        return new ResponseEntity<>(
                ErrorMessage.builder().message(errorMessage).build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleArgumentNotValidException(MethodArgumentNotValidException ex, Locale locale) {
        BindingResult result = ex.getBindingResult();
        List<String> errorMessages = result.getAllErrors()
                .stream()
                .map(objectError -> messages.getMessage(objectError.getObjectName(), locale))
                .collect(Collectors.toList());
        return new ResponseEntity<>(
                ErrorMessage.builder().messages(errorMessages).build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleExceptions(Exception ex, Locale locale) {
        String errorMessage = ex.getMessage();
        errorMessage = messages.getMessage(errorMessage != null ? errorMessage : ex.getClass().getName(), null, locale);
        ex.printStackTrace();
        return new ResponseEntity<>(
                ErrorMessage.builder().message(errorMessage).build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}