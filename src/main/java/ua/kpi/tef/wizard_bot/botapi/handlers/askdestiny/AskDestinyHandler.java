package ua.kpi.tef.wizard_bot.botapi.handlers.askdestiny;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.kpi.tef.wizard_bot.botapi.BotState;
import ua.kpi.tef.wizard_bot.botapi.InputMessageHandler;
import ua.kpi.tef.wizard_bot.cache.UserDataCache;
import ua.kpi.tef.wizard_bot.service.ReplyMessagesService;


/**
 * Спрашивает пользователя- хочет ли он получить предсказание.
 */

@Slf4j
@Component
public class AskDestinyHandler implements InputMessageHandler {
    private static final String ASK_MESSAGE = "Привет! Хочешь узнать свою судьбу?";
    private UserDataCache userDataCache;
    private ReplyMessagesService messagesService;

    public AskDestinyHandler(UserDataCache userDataCache,
                             ReplyMessagesService messagesService) {
        this.userDataCache = userDataCache;
        this.messagesService = messagesService;
    }

    @Override
    public SendMessage handle(Message message) {
        return processUsersInput(message);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.ASK_DESTINY;
    }

    private SendMessage processUsersInput(Message inputMsg) {
        int userId = inputMsg.getFrom().getId();
        long chatId = inputMsg.getChatId();

        SendMessage replyToUser = messagesService.getReplyMessage(chatId, ASK_MESSAGE);
        userDataCache.setUsersCurrentBotState(userId, BotState.FILLING_PROFILE);

        return replyToUser;
    }
}

