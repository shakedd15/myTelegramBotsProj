package commants;

import bots.botsConfiguration.BotFather;
import bots.botsMessageHandler.BotAPI;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.objects.Update;

public class ShakedMessageCommants {

    public static SendMessage welcomeMessege(Update update) {
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendSticker(update);
        return sendMessage.setText("hey " + update.getMessage().getFrom().getFirstName() + " I'm glad you here!");
    }

    public static void sendSticker(Update update){
        SendSticker sendSticker = new SendSticker().setChatId(update.getMessage().getChatId());
        sendSticker.setSticker("CAADAgADiAQAAs7yAsIxvDOIYVLpQI");
        sendSticker(update);
    }

    public static SendMessage shakedWroteThis(Update update) {
        int[] code = {0x1F430};
        String s = new String(code, 0 , code.length);
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText( s + "שקד היא זו שכתבה את הבוט הזה");
    }

    public static SendMessage illan(Update update) {
        int[] code = {0x1F430};
        String s = new String(code, 0 , code.length);
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText( s + "היוש אילנצ'יק");
    }
}
