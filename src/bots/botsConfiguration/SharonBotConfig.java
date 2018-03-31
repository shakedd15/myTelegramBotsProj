package bots.botsConfiguration;

import bots.botsMessageHandler.BotAPI;
import bots.botsMessageHandler.SharonBot;
import org.telegram.telegrambots.api.objects.Update;

public class SharonBotConfig extends BotFather {
    @Override
    public void onUpdateReceived(Update update) {
        BotAPI bot;
        bot = new SharonBot();
        start(update, bot);
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
