package bots.botsMessageHandler;

import bots.botsMessageHandler.BotAPI;
import commants.StartCommant;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class SharonBot implements BotAPI {

    public SendMessage requestBot(Update update){
        SendMessage sendMessage;
        String messageContant = update.getMessage().getText();

        switch (messageContant){
            case "/start":{
                sendMessage = StartCommant.welcomeMessege(update);
                break;
            }
            case "מי בנה את הבוט הזה?":{
                sendMessage = StartCommant.shakedWroteThis(update);
                break;
            }
            case "מי אתה?":{
                sendMessage = StartCommant.howAmI(update);
                break;
            }
            case "/shafan":{
                sendMessage = StartCommant.shafan(update);
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
