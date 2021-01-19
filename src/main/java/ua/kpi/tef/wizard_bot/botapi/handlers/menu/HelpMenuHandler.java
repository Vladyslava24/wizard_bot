package ua.kpi.tef.wizard_bot.botapi.handlers.menu;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.kpi.tef.wizard_bot.botapi.BotState;
import ua.kpi.tef.wizard_bot.botapi.InputMessageHandler;
import ua.kpi.tef.wizard_bot.service.MainMenuService;
import ua.kpi.tef.wizard_bot.service.ReplyMessagesService;

@Component
public class HelpMenuHandler implements InputMessageHandler {
    private MainMenuService mainMenuService;
    private ReplyMessagesService messagesService;

    public HelpMenuHandler(MainMenuService mainMenuService, ReplyMessagesService messagesService) {
        this.mainMenuService = mainMenuService;
        this.messagesService = messagesService;
    }

    @Override
    public SendMessage handle(Message message) {
        return mainMenuService.getMainMenuMessage(message.getChatId(),
                messagesService.getReplyText("reply.showHelpMenu"));
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_HELP_MENU;
    }
}
