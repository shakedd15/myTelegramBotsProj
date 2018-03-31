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
        System.out.println(update.getMessage().getFrom().getFirstName() + ": " + update.getMessage().getText());
        SendMessage sendMessage = null;
        boolean isMessageToSend = true;
        BotAPI bot;
        switch (getBotUsername()){
            case "SharonLuzonBot":{
                bot = new SharonBot();
                sendMessage = bot.requestBot(update);
                break;
            }
            case "ShakedMessegeBot":{

            }
        }

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
        return BotsInfoEnum.SHAKED_MESSAGE_BOT.name();
    }

    @Override
    public String getBotToken() {
        return BotsInfoEnum.SHAKED_MESSAGE_BOT_TOKEN.name();
    }
}
