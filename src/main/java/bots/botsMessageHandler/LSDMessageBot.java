package bots.botsMessageHandler;

import bots.botsMessageHandler.utils.BotAPI;
import bots.botsMessageHandler.utils.MessegeTypeUtils;
import commants.SharonBotCommants;
import commants.lsdBot.LSDBotResponsed;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class LSDMessageBot implements BotAPI {
    @Override
    public MessegeTypeUtils requestBot(Update update) {
        SendMessage sendMessage = null;
        String messageContant = update.getMessage().getText();

        switch (messageContant){
            case "/add":{
                sendMessage = LSDBotResponsed.addMessege(update);
                break;
            }
            case "/add@LSD_TorD_bot":{
                sendMessage = LSDBotResponsed.addMessege(update);
                break;
            }
            case "/start":{
                sendMessage = LSDBotResponsed.startGame(update);
                break;
            }
            case "/start@LSD_TorD_bot":{
                sendMessage = LSDBotResponsed.startGame(update);
                break;
            }
            case "נתחיל במשחק":{
                sendMessage = SharonBotCommants.howAmI(update);
                break;
            }
            case "/shafan":{
                sendMessage = SharonBotCommants.shafan(update);
                break;
            }
            default: {
                break;
            }
        }

        return new MessegeTypeUtils(sendMessage);
    }
}
