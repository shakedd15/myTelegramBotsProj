package bots.botsMessageHandler;

import bots.DaysCalculator;
import bots.botsMessageHandler.utils.BotAPI;
import bots.botsMessageHandler.utils.MessegeTypeUtils;
import commants.SharonBotCommants;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SharonBot implements BotAPI {

    public MessegeTypeUtils requestBot(Update update){
        MessegeTypeUtils messegeTypeUtils = null;
        SendMessage sendMessage = null;
        String messageContant = update.getMessage().getText();
        if(messageContant != null){
            switch (messageContant){
                case "/start":{
                    messegeTypeUtils = new MessegeTypeUtils(SharonBotCommants.welcomeMessege(update));
                    break;
                }
                case "מי אתה?":{
                    messegeTypeUtils = new MessegeTypeUtils(SharonBotCommants.howAmI(update));
                    break;
                }
                case "bhxhu":{
                    messegeTypeUtils = new MessegeTypeUtils(SharonBotCommants.shafan(update));
                    break;
                }case "שלישיה":{
                    messegeTypeUtils = SharonBotCommants.changeSongsKeyboard(update);
                    break;
                }case "1 חודשים קדימה":{
                    messegeTypeUtils = new MessegeTypeUtils(DaysCalculator.calculateDays(update, 1));
                    break;
                }case "2 חודשים קדימה":{
                    messegeTypeUtils = new MessegeTypeUtils(DaysCalculator.calculateDays(update, 2));
                    break;
                }case "3 חודשים קדימה":{
                    messegeTypeUtils = new MessegeTypeUtils(DaysCalculator.calculateDays(update, 3));
                    break;
                }case "4 חודשים קדימה":{
                    messegeTypeUtils = new MessegeTypeUtils(DaysCalculator.calculateDays(update, 4));
                    break;
                }case "5 חודשים קדימה":{
                    messegeTypeUtils = new MessegeTypeUtils(DaysCalculator.calculateDays(update, 5));
                    break;
                }case "6 חודשים קדימה":{
                    messegeTypeUtils = new MessegeTypeUtils(DaysCalculator.calculateDays(update, 6));
                    break;
                }case "7 חודשים קדימה":{
                    messegeTypeUtils = new MessegeTypeUtils(DaysCalculator.calculateDays(update, 7));
                    break;
                }case "8 חודשים קדימה":{
                    messegeTypeUtils = new MessegeTypeUtils(DaysCalculator.calculateDays(update, 8));
                    break;
                }case "9 חודשים קדימה":{
                    messegeTypeUtils = new MessegeTypeUtils(DaysCalculator.calculateDays(update, 9));
                    break;
                }
                default: {
                    messegeTypeUtils = new MessegeTypeUtils(this.ifStatments(messageContant, update));
                    break;
                }
            }

        } else {
            messegeTypeUtils = new MessegeTypeUtils(SharonBotCommants.noStickers(update));
        }

        return messegeTypeUtils;
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
