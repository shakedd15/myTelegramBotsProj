package bots.botsMessageHandler;

import commants.SharonBotCommants;
import commants.lsdBot.LSDBotResponsed;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class LSDMessageBot implements BotAPI{
    @Override
    public SendMessage requestBot(Update update) {
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

        return sendMessage;
    }
}
