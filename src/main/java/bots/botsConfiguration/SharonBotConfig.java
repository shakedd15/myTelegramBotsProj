package bots.botsConfiguration;

import bots.botsConfiguration.botFatherSataters.BotFatherSharonLuzon;
import bots.botsMessageHandler.utils.BotAPI;
import bots.botsMessageHandler.SharonBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SharonBotConfig extends BotFatherSharonLuzon {

    public void onUpdateReceived(Update update) {
        BotAPI bot;
        bot = new SharonBot();
        start(update, bot);
    }


    public String getBotUsername() {
        return "SharonLuzonBot";
    }

    @Override
    public String getBotToken() {
        return "571066645:AAEh9MQPxXMvt1C-deicirUzet1ja2xUks8";
    }
}
