package bots.botsConfiguration;

import bots.botsMessageHandler.BotAPI;
import bots.botsMessageHandler.ShakedMessageBot;
import bots.botsMessageHandler.SharonBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class ShakedBotConfig extends BotFather  {

    @Override
    public void onUpdateReceived(Update update) {
        BotAPI bot;
        bot = new ShakedMessageBot();
        start(update, bot);
    }

    @Override
    public String getBotUsername() {
        return "ShakedMessegeBot";
    }

    @Override
    public String getBotToken() {
        return "579939185:AAF1tmwx4UWf1wE0sot0VsA8Pj2AaGPGsHQ";
    }
}
