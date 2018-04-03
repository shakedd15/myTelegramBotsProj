package bots.botsMessageHandler;

import commants.ShakedMessageCommants;
import commants.SharonBotCommants;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class ShakedMessageBot implements BotAPI {

    @Override
    public SendMessage requestBot(Update update) {
        SendMessage sendMessage;
        String messageContant = update.getMessage().getText();

        switch (messageContant){
            case "/start":{
                sendMessage = ShakedMessageCommants.welcomeMessege(update);
                break;
            }
            case "מי בנה את הבוט הזה?":{
                sendMessage = ShakedMessageCommants.shakedWroteThis(update);
                break;
            }
            case "אילן":{
                sendMessage = ShakedMessageCommants.illan(update);
                break;
            }
            default: {
                sendMessage = null;
                break;
            }
        }
        return sendMessage;
    }
}
