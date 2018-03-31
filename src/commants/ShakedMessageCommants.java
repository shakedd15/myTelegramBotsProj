package commants;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class ShakedMessageCommants {

    public static SendMessage welcomeMessege(Update update) {
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText("hey " + update.getMessage().getFrom().getFirstName() + " I'm glad you here!");
    }

    public static SendMessage shakedWroteThis(Update update) {
        int[] code = {0x1F430};
        String s = new String(code, 0 , code.length);
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText( s + "שקד היא זו שכתבה את הבוט הזה");
    }
}
