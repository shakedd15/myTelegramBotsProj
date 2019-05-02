package bots.botsMessageHandler.utils;


import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotAPI {

    MessegeTypeUtils requestBot(Update update);
}
