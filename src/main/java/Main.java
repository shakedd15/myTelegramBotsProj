import bots.botsConfiguration.SharonBotConfig;
import bots.botsConfiguration.ZivBotConfig;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {

    public static void main(String args[]){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        SharonBotConfig botSharon = new SharonBotConfig();
        ZivBotConfig botzivBotConfig = new ZivBotConfig();
//        LSDBotConfig lsdBotConfig = new LSDBotConfig();
        try
        {
            telegramBotsApi.registerBot(botSharon);
            telegramBotsApi.registerBot(botzivBotConfig);
//            telegramBotsApi.registerBot(lsdBotConfig);
        }catch (TelegramApiRequestException e){
            e.printStackTrace();
        }

    }
}
