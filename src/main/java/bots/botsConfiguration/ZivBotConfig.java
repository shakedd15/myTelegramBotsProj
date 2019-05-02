package bots.botsConfiguration;

import bots.botsConfiguration.botFatherSataters.BotFatherZivBerkoich;
import bots.botsMessageHandler.utils.BotAPI;
import bots.botsMessageHandler.ZivMessageBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ZivBotConfig extends BotFatherZivBerkoich {

    public void onUpdateReceived(Update update) {
        BotAPI bot;
        bot = new ZivMessageBot();
        startZiv(update, bot);
    }

    public String getBotUsername() {
        return "ZivBerkovichBot";
    }

    @Override
    public String getBotToken() {
        return "481231400:AAH4T9dzvIjn86aZgeEOtnB9uJmzAdIPUKs";
    }
}
