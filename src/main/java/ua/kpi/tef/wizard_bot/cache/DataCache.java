package ua.kpi.tef.wizard_bot.cache;

import ua.kpi.tef.wizard_bot.botapi.BotState;
import ua.kpi.tef.wizard_bot.botapi.handlers.fillingprofile.UserProfileData;

public interface DataCache {
    void setUsersCurrentBotState(int userId, BotState botState);

    BotState getUsersCurrentBotState(int userId);

    UserProfileData getUserProfileData(int userId);

    void saveUserProfileData(int userId, UserProfileData userProfileData);
}
