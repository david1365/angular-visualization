package ir.caspco.visualization.config.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Getter
@Builder
public class ErrorMessage {
    private String message;
    private List<String> messages;
}
