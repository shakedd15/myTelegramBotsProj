package commants;

import bots.botsMessageHandler.utils.MessegeTypeUtils;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class ZivMessageCommants {

    public static SendMessage welcomeMessege(Update update) {
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendSticker(update);
        return sendMessage.setText("היי " + update.getMessage().getFrom().getFirstName() + "\n" + "אני הבוט של זיו");
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


    public static MessegeTypeUtils changeSongsKeyboard(Update update) {
        final Message message = update.getMessage();
        ReplyKeyboard markup = null;
            markup = new ReplyKeyboardMarkup();
            final List<KeyboardRow> keyboard = ((ReplyKeyboardMarkup) markup).getKeyboard();
            for (int i = 0; i < 1; i++)
            {
                if (keyboard.isEmpty() || (keyboard.get(keyboard.size() - 1).size() >= 3))
                {
                    keyboard.add(new KeyboardRow());
                }
                keyboard.get(keyboard.size() - 1).add(new KeyboardButton().setText("🔘 שיר מספר #" + (i + 1)));
            }
        final SendMessage msg = new SendMessage();
        msg.setChatId(Long.toString(message.getChat().getId()));
        msg.setText("Your text here");
        msg.setReplyToMessageId(message.getMessageId());
        msg.setReplyMarkup(markup);

        return new MessegeTypeUtils(msg);
    }

    public static MessegeTypeUtils sendSong1(Update update){
        SendAudio sendAudio = new SendAudio().setChatId(update.getMessage().getChatId());
        sendAudio.setAudio("CQADBAADdQUAArS5GVCbcYtFmDZvZQI");
        return new MessegeTypeUtils(sendAudio);
    }

    public static MessegeTypeUtils defaultM(Update update) {
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        if(update.getMessage().getFrom().getFirstName().equals("זיו") || update.getMessage().getFrom().getFirstName().equals("Ziv")
                || update.getMessage().getFrom().getFirstName().equals("Cyuka")){
            sendMessage.setText("היי יפיופה" + "\n" + "כרגע הבוט יכול לשלוח שירים בלבד" +
                    "\n" +" על מנת לראות את רשימת השירים יש לבקש- 'שירים'");
        } else {
            sendMessage.setText("הי " + update.getMessage().getFrom().getFirstName() + "\n" + "כרגע הבוט יכול לשלוח שירים בלבד" +
                    "\n" +" על מנת לראות את רשימת השירים יש לבקש- 'שירים'");
        }

        return new MessegeTypeUtils(sendMessage);
    }
}