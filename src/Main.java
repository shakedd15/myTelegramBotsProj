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
        ShakedBotConfig botShaked = new ShakedBotConfig();

        try
        {
            telegramBotsApi.registerBot(botSharon);
            telegramBotsApi.registerBot(botShaked);
        }catch (TelegramApiRequestException e){
            e.printStackTrace();
        }

    }
}
