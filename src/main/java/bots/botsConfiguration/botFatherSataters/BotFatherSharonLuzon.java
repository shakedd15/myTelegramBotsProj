package bots.botsConfiguration.botFatherSataters;

import bots.botsMessageHandler.utils.BotAPI;
import bots.botsMessageHandler.utils.MessegeTypeUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class BotFatherSharonLuzon extends TelegramLongPollingBot {

    public void start(Update update, BotAPI bot){
//        sendToBOTH("420287597", update.getMessage().getChatId(), update);
//        sendToBOTH("461557139", update.getMessage().getChatId(), update);
//        sendToBOTH("536854945", update.getMessage().getChatId(), update);
        System.out.println(update.getMessage().getFrom().getFirstName() + ": " + update.getMessage().getText());
        System.out.println(update.getMessage().getChatId());

        //send the messege that recive from the user
        sendTomySeld(update.getMessage().getFrom().getFirstName() + ": " + update.getMessage().getText());

        MessegeTypeUtils messegeTypeUtils;
        messegeTypeUtils = bot.requestBot(update);
        if(messegeTypeUtils != null){
            try {
                if(messegeTypeUtils.getSendMessage()!= null){
                    execute(messegeTypeUtils.getSendMessage());
                }
                if(messegeTypeUtils.getSendAudio()!= null){
                    execute(messegeTypeUtils.getSendAudio());
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendTomySeld(String fuckyou){
        SendMessage sendMessage;
        sendMessage = new SendMessage().setChatId("536854945");
        sendMessage.setText(fuckyou);
        if(sendMessage != null){
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendToBOTH(String chatd, Long shakedId, Update update){
        String s = String.valueOf(shakedId);
        if(s.contains("536854945")){
            SendMessage sendMessage;
            sendMessage = new SendMessage().setChatId(chatd);
            sendMessage.setText(update.getMessage().getText());
            if(sendMessage != null){
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}