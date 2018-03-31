import GlobalEnums.BotsInfoEnum;
import bots.botsMessageHandler.BotAPI;
import bots.botsMessageHandler.SharonBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

    }


    @Override
    public String getBotUsername() {
        return BotsInfoEnum.SHAKED_MESSAGE_BOT.name();
    }

    @Override
    public String getBotToken() {
        return BotsInfoEnum.SHAKED_MESSAGE_BOT_TOKEN.name();
    }
}
