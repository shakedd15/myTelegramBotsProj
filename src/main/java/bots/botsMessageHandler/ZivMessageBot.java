package bots.botsMessageHandler;

import bots.botsMessageHandler.utils.BotAPI;
import bots.botsMessageHandler.utils.MessegeTypeUtils;
import commants.ZivMessageCommants;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ZivMessageBot implements BotAPI {

    public MessegeTypeUtils requestBot(Update update) {
        MessegeTypeUtils messegeTypeUtils;
        String messageContant = update.getMessage().getText();
//        CQADBAADdQUAArS5GVCbcYtFmDZvZQI
        switch (messageContant){
            case "/start":{
                messegeTypeUtils = ZivMessageCommants.defaultM(update);
                break;
            }
            default: {
                messegeTypeUtils = this.ifStatments(messageContant, update);
                break;
            }
        }
        return messegeTypeUtils;
    }

    private MessegeTypeUtils ifStatments (String messageContant, Update update){
        MessegeTypeUtils messegeTypeUtils = null;
        if(messageContant.contains("שירים")){
            messegeTypeUtils = ZivMessageCommants.changeSongsKeyboard(update);
        } else if (messageContant.contains("שיר מספר #1")){
            messegeTypeUtils = ZivMessageCommants.sendSong1(update);
        } else {
            messegeTypeUtils = ZivMessageCommants.defaultM(update);
        }

        if(messegeTypeUtils.getSendMessage() != null){
            System.out.println("bot: " + messegeTypeUtils.getSendMessage());
        }

        return messegeTypeUtils;
    }
}
