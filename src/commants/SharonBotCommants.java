package commants;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class SharonBotCommants {

    public static SendMessage welcomeMessege(Update update) {
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText("hey " + update.getMessage().getFrom().getFirstName() + " I'm the real Sharon Luzon");
    }

    public static SendMessage shakedWroteThis(Update update) {
        int[] code = {0x1F430};
        String s = new String(code, 0 , code.length);
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText( s + "שקד היא זו שכתבה את הבוט הזה");
    }

    public static SendMessage howAmI(Update update) {
        int[] code = {0x1F430};
        String s = new String(code, 0 , code.length);

        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText("קודם כל אני בכלל " + s + " שנית, תוכל לקרוא עלי בקישור: "+ "\n"
                + "https://he.wikipedia.org/wiki/%D7%A9%D7%A8%D7%95%D7%9F_%D7%9C%D7%95%D7%96%D7%95%D7%9F");
    }

    public static SendMessage shafan(Update update) {
        int[] code = {0x1F430};
        String s = new String(code, 0 , code.length);

        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText(s);
    }
}
