package ua.kpi.tef.wizard_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WizardBotApplication {

    public static void main(String[] args) {
        System.setProperty("server.port","8088");
        SpringApplication.run(WizardBotApplication.class, args);
    }

}
