import bots.botsConfiguration.LSDBotConfig;
import bots.botsConfiguration.ShakedBotConfig;
import bots.botsConfiguration.SharonBotConfig;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class Main {

    public static void main(String args[]){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        SharonBotConfig botSharon = new SharonBotConfig();
//        ShakedBotConfig botShaked = new ShakedBotConfig();
//        LSDBotConfig lsdBotConfig = new LSDBotConfig();
        try
        {
            telegramBotsApi.registerBot(botSharon);
//            telegramBotsApi.registerBot(botShaked);
//            telegramBotsApi.registerBot(lsdBotConfig);
        }catch (TelegramApiRequestException e){
            e.printStackTrace();
        }

    }
}
