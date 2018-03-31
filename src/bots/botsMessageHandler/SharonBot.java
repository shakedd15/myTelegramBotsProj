package bots.botsMessageHandler;

import commants.SharonBotCommants;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class SharonBot implements BotAPI {

    public SendMessage requestBot(Update update){
        SendMessage sendMessage;
        String messageContant = update.getMessage().getText();

        switch (messageContant){
            case "/start":{
                sendMessage = SharonBotCommants.welcomeMessege(update);
                break;
            }
            case "מי בנה את הבוט הזה?":{
                sendMessage = SharonBotCommants.shakedWroteThis(update);
                break;
            }
            case "מי אתה?":{
                sendMessage = SharonBotCommants.howAmI(update);
                break;
            }
            case "/shafan":{
                sendMessage = SharonBotCommants.shafan(update);
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
