package bots.botsConfiguration;

import bots.botsConfiguration.botFatherSataters.BotFatherSharonLuzon;
import bots.botsMessageHandler.utils.BotAPI;
import bots.botsMessageHandler.LSDMessageBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class LSDBotConfig extends BotFatherSharonLuzon {

    public void onUpdateReceived(Update update) {
        BotAPI bot;
        bot = new LSDMessageBot();
        start(update, bot);
    }

    public String getBotUsername() {
        return "LSD_TorD_bot";
    }

    @Override
    public String getBotToken() {
        return "602659912:AAGKriQldGZvptOYhuKciPMjCrMmfwoVtXk";
    }
}
