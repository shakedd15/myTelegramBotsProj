package bots.botsConfiguration;

import bots.botsMessageHandler.BotAPI;
import bots.botsMessageHandler.SharonBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class SharonBotConfig  extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getFrom().getFirstName() + ": " + update.getMessage().getText());
        SendMessage sendMessage;
        BotAPI bot;
        bot = new SharonBot();
        sendMessage = bot.requestBot(update);
        if(sendMessage != null){
            try {
                sendMessage(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public String getBotUsername() {
        return "SharonLuzonBot";
    }

    @Override
    public String getBotToken() {
        return "571066645:AAEh9MQPxXMvt1C-deicirUzet1ja2xUks8";
    }
}
