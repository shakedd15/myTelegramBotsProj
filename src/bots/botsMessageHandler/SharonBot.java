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

        return sendMessage;
    }

    private SendMessage ifStatments (String messageContant, Update update){
        SendMessage sendMessage = null;
        if(messageContant.contains("ארנבים")){
            sendMessage = SharonBotCommants.AlotOfshafan(update);
        } else if(messageContant.contains("ארנב")){
            sendMessage = SharonBotCommants.shafan(update);
        }else if(messageContant.contains("טיפש") || messageContant.contains("אוטיסט") || messageContant.contains("מפגר")
                || messageContant.contains("דביל") || messageContant.contains("זונה") || messageContant.contains("חרא")
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
