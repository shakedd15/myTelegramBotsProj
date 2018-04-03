package bots.botsConfiguration;

import bots.botsMessageHandler.BotAPI;
import bots.botsMessageHandler.SharonBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public abstract class BotFather extends TelegramLongPollingBot{

    public void start(Update update, BotAPI bot){
        System.out.println(update.getMessage().getFrom().getFirstName() + update.getMessage().getFrom().getLastName() + ": " + update.getMessage().getText());
        SendMessage sendMessage;
        sendMessage = bot.requestBot(update);
        if(sendMessage != null){
            try {
                sendMessage(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
