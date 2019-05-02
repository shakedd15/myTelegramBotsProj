package commants.lsdBot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class LSDBotResponsed {

    public static SendMessage addMessege(Update update) {
//        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
//        LSDUser lsdUser = new LSDUser(update.getMessage().getFrom().getId(), update.getMessage().getFrom().getFirstName(), false);
//        ObjectMapper mapperObj = new ObjectMapper();
//        try {
////            String text = new String(Files.readAllBytes(Paths.get("lsdUsers.json")), StandardCharsets.UTF_8);
//            JSONArray arr;
//            if(text.equals("")){
//                arr = new JSONArray();
//            } else {
//                 arr = new JSONArray(text);
//            }
//
//            boolean found = false;
//            for (int i = 0; i < arr.length(); i++)
//                if (arr.getString(i).contains(update.getMessage().getFrom().getId().toString())) {
//                    found = true;
//                    break;
//                }
//            if(!found){
//                String jsonStr = mapperObj.writeValueAsString(lsdUser);
//                arr.put(jsonStr);
//                FileWriter fileWriter = new FileWriter("lsdUsers.json");
//                PrintWriter printWriter = new PrintWriter(fileWriter);
//                printWriter.print(arr);
//                printWriter.close();
//                sendMessage.setText("@" + update.getMessage().getFrom().getUserName() + " היי ברגע זה התווספת לרשימת ההפצה");
//            } else {
//                sendMessage.setText("@" + update.getMessage().getFrom().getUserName() + "תפסיק/י ללחוץ על הפקודה הזו!!! את/ה כבר נמצא/ת במשחק");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return sendMessage;

        return null;
    }

    public static SendMessage startGame(Update update) {
        JSONArray arr = readList();
        ObjectMapper m = new ObjectMapper();
        try {
            LSDUser products = m.readValue(arr.getString(0), new TypeReference<LSDUser>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static JSONArray readList(){
//        JSONArray arr = new JSONArray();
//        try {
//            String text = new String(Files.readAllBytes(Paths.get("lsdUsers.json")), StandardCharsets.UTF_8);
//            if (text.equals("")) {
//                arr = new JSONArray();
//            } else {
//                arr = new JSONArray(text);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return arr;
        return null;
    }
}
