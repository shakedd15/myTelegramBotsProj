package bots.botsMessageHandler;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public interface BotAPI {

    SendMessage requestBot(Update update);
}
