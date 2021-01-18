package ua.kpi.tef.wizard_bot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**Работает с файлом шаблоном "ответных сообщений" messages.properties
 *
 * @author Sergei Viacheslaev
 */
@Service
public class LocaleMessageService {
    //private final Locale locale;
    //private final MessageSource messageSource;

    /*public LocaleMessageService(@Value("ru-RU") String localeTag, MessageSource messageSource) {
        this.messageSource = messageSource;
        this.locale = Locale.forLanguageTag(localeTag);
    }*/


    public String getMessage(String message) {
        return message;
        //return messageSource.getMessage(message, null, locale);
    }

    public String getMessage(String message, Object... args) {
        return message;
        //return messageSource.getMessage(message, args, locale);
    }
}
