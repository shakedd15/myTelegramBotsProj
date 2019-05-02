package bots.botsConfiguration.botFatherSataters;

import bots.botsMessageHandler.utils.BotAPI;
import bots.botsMessageHandler.utils.MessegeTypeUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class BotFatherZivBerkoich extends TelegramLongPollingBot {

    public void startZiv(Update update, BotAPI bot){
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

                    //send the messege that recive from the user
                    sendAudTomySeld(messegeTypeUtils.getSendAudio());
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

    public void sendAudTomySeld(SendAudio fuckyou){
        if(fuckyou != null){
            fuckyou.setTitle("bot: ");
            fuckyou.setChatId("536854945");
            try {
                execute(fuckyou);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
