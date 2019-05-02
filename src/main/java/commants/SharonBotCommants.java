package commants;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SharonBotCommants {

    public static SendMessage welcomeMessege(Update update) {
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
//        sendSticker(update);
        return sendMessage.setText("hey " + update.getMessage().getFrom().getFirstName() + " I'm the real Sharon Luzon");
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

    public static SendMessage noStickers(Update update) {

        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText("בלי סטיקרים!!!!!!!!! יש לי לב חלש.");
    }

    public static SendMessage AlotOfshafan(Update update) {
        int[] code = {0x1F430};
        String s = new String(code, 0 , code.length);

        //get random number
        Random rand = new Random();
        int  n = rand.nextInt(25) + 1;

        String shirshor = "";
        for(int i = 0; i < n; i++){
            shirshor = shirshor + "" + s + "";
        }

        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText(shirshor);
    }

    public static SendMessage getHey(Update update) {
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText(helloGenerator());
    }

    private static String helloGenerator(){
        List<String> curses = new ArrayList<>();
        curses.add("ברוך הבא לבוט שרון לוזון");
        curses.add("שלום שלום");
        curses.add("היי, מה שלומך? תבקש ממני ארנב");
        curses.add("היי לך, בוט שרון לוזון מחכה לארנבים");
        curses.add("היי לך, בוט שרון לוזון מחכה לארנבים");

        //get random number
        Random rand = new Random();
        int  n = rand.nextInt(4);

        return curses.get(n);
    }

    public static SendMessage getCurse(Update update) {
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText(curseGenerator());
    }

    private static String curseGenerator(){
        List<String> curses = new ArrayList<>();
        curses.add("כוסאמכערס אל תקלל אותי");
        curses.add("שים לב למילותיך, בוט שרון לוזון הינו בוט רציני");
        curses.add("אל תהיה פרחח מניאק");
        curses.add("טפי לך תשטוף את הפה עם סבון");
        curses.add("סליחה, אני לא יודע לתרגם מילים כאלו");
        curses.add("סתמי יזונה");

        //get random number
        Random rand = new Random();
        int  n = rand.nextInt(4);

        return curses.get(n);
    }

    public static SendMessage shakedNameHandler(Update update) {
        List<String> curses = new ArrayList<>();
        curses.add("שקד היא האלוהים שלי");
        curses.add("שקד היא הדבר הכי טוב שקרה לי בחיים");
        curses.add("שקד היא הדבר הכי טוב שקיים היום");
        curses.add("שקד היא היצור המופלא שיצר אותי");
        curses.add("אני מאוהב בשקד, וגם את/ה צריכ/ה להיות");
        curses.add("שקד מדהימה, בלעדיה אני לא קיים.");

        //get random number
        Random rand = new Random();
        int  n = rand.nextInt(4);

        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        return sendMessage.setText(curses.get(n));
    }

    public static SendMessage defaultM(Update update) {
        //Send Messege
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());

        if(update.getMessage().getFrom().getFirstName().equals("זיו") || update.getMessage().getFrom().getFirstName().equals("Ziv")
                || update.getMessage().getFrom().getFirstName().equals("Cyuka")){
            return sendMessage.setText("היי כוסית" + "\n" +
                    "\n" + "הגעת לבוט שרון לוזון! אני לא יודע לזיין כמו שרון לוזון, כי אני רק בוט מזדיין, אבל תוכלי כרגע: " + "\n" +
                    "לברך אותי לשלום" + "\n" +
                    "לבקש ארנב או ארנבים" + "\n" +
                    "לשאול אותי- 'מי אתה?'" + "\n" +
                    "\n" + "בוט שרון לוזון אינו אוהב קללות");
        }

        return sendMessage.setText("הי " + update.getMessage().getFrom().getFirstName() +
                "\n" + "הגעת לבוט שרון לוזון! האופציות כרגע הן: " + "\n" +
                "1. לברך אותי לשלום" + "\n" +
                "2. לבקש   ארנב או ארנבים" + "\n" +
                "3. לשאול אותי- 'מי אתה?'" + "\n" +
                "\n" + "בוט שרון לוזון אינו אוהב קללות");
    }
}
