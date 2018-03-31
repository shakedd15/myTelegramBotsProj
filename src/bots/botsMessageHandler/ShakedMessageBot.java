package bots.botsMessageHandler;

import bots.botsMessageHandler.BotAPI;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class ShakedMessageBot implements BotAPI {

    @Override
    public SendMessage requestBot(Update update) {
        return null;
    }
}
