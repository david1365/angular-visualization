package ir.caspco.visualization.body.components;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Component
public class Messages {
    private MessageSource messageSource;

    public Messages(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code) {
        return getMessage(code, new Object[0], new Locale("fa", "IR"));
    }

    public String getMessage(String code, @Nullable Object[] args) {
        return getMessage(code, args, new Locale("fa", "IR"));
    }

    public String getMessage(String code, Locale locale) {
        return getMessage(code, new Object[0], locale);
    }

    public String getMessage(String code, @Nullable Object[] args, Locale locale) {
        try {
            return messageSource.getMessage(code, args, locale);
        } catch (NoSuchMessageException e) {
            return code;
        }
    }
}
