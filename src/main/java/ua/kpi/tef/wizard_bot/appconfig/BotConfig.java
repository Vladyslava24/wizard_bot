package ua.kpi.tef.wizard_bot.appconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import ua.kpi.tef.wizard_bot.WizardBot;
import ua.kpi.tef.wizard_bot.botapi.TelegramFacade;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    private DefaultBotOptions.ProxyType proxyType;
    private String proxyHost;
    private int proxyPort;

    @Bean
    public WizardBot wizardBot(TelegramFacade telegramFacade) {
        DefaultBotOptions options = ApiContext
                .getInstance(DefaultBotOptions.class);

        options.setProxyHost("localhost");
        options.setProxyPort(9150);
        options.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);

        WizardBot wizardBot = new WizardBot(options, telegramFacade);
        wizardBot.setBotUserName("@wizard_test24_bot");
        wizardBot.setBotToken("1596141497:AAEoKb25KvjlDbFOVuEiPE9Z1hDBf2gCRW0");
        wizardBot.setWebHookPath("https://6c0985154434.ngrok.io");
        return wizardBot;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
