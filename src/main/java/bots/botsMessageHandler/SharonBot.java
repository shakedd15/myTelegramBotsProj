package bots.botsMessageHandler;

import bots.botsMessageHandler.utils.BotAPI;
import bots.botsMessageHandler.utils.MessegeTypeUtils;
import commants.SharonBotCommants;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SharonBot implements BotAPI {

    public MessegeTypeUtils requestBot(Update update){
        MessegeTypeUtils messegeTypeUtils;
        SendMessage sendMessage;
        String messageContant = update.getMessage().getText();
        if(messageContant != null){
            switch (messageContant){
                case "/start":{
                    sendMessage = SharonBotCommants.welcomeMessege(update);
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
                    sendMessage = this.ifStatments(messageContant, update);
                    break;
                }
            }

        } else {
            sendMessage = SharonBotCommants.noStickers(update);
        }

        return new MessegeTypeUtils(sendMessage);
    }

    private SendMessage ifStatments (String messageContant, Update update){
        SendMessage sendMessage = null;
        if(messageContant.contains("ארנבים")){
            sendMessage = SharonBotCommants.AlotOfshafan(update);
        } else if(messageContant.contains("ארנב")){
            sendMessage = SharonBotCommants.shafan(update);
        }else if(messageContant.contains("טיפש") || messageContant.contains("אוטיסט") || messageContant.contains("מפגר")
                || messageContant.contains("דביל") || messageContant.contains("זונה") || messageContant.contains("חרא") || messageContant.contains("סאמכ") || messageContant.contains("סעעמק")
                || messageContant.contains("אידיוט") || messageContant.contains("זיבי") || messageContant.contains("נעוות המרדות") || messageContant.contains("זובי")){
            sendMessage = SharonBotCommants.getCurse(update);
        }  else if(messageContant.contains("היי") || messageContant.contains("שלום") || messageContant.contains("hey")){
            sendMessage = SharonBotCommants.getHey(update);
        }  else if(messageContant.contains("מי בנה אותך") || messageContant.contains("מי כתב אותך")
                || messageContant.contains("מי יצר אותך") || messageContant.contains("מי בנה את הבוט")
                || messageContant.contains("מי יצר את הבוט") || messageContant.contains("מי בנתה אותך")
                || messageContant.contains("מי יצרה אותך") || messageContant.contains("מי כתבה אותך")){
            sendMessage = SharonBotCommants.shakedWroteThis(update);
        }  else if(messageContant.contains("שקד")){
            sendMessage = SharonBotCommants.shakedNameHandler(update);
        }else if(messageContant.contains("מי אתה")){
            sendMessage = SharonBotCommants.howAmI(update);
        } else {
            sendMessage = SharonBotCommants.defaultM(update);
        }

        System.out.println("bot: " + sendMessage.getText());

        return sendMessage;
    }
}
