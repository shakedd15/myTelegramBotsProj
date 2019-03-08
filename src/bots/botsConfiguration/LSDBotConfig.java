package bots.botsConfiguration;

import bots.botsMessageHandler.BotAPI;
import bots.botsMessageHandler.LSDMessageBot;
import org.telegram.telegrambots.api.objects.Update;

public class LSDBotConfig extends BotFather{
    @Override
    public void onUpdateReceived(Update update) {
        BotAPI bot;
        bot = new LSDMessageBot();
        start(update, bot);
    }

    @Override
    public String getBotUsername() {
        return "LSD_TorD_bot";
    }

    @Override
    public String getBotToken() {
        return "602659912:AAGKriQldGZvptOYhuKciPMjCrMmfwoVtXk";
    }
}
