package bots;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaysCalculator {

    public static ArrayList<SendMessage> calculateDays(Update update, int months){
        ArrayList<SendMessage> freeFriday = new ArrayList<>();
        Date today = new Date();
        Calendar closeWeekend = Calendar.getInstance();
        closeWeekend.setTime(today);
        int dayOfWeek = closeWeekend.get(Calendar.DAY_OF_WEEK);

        if(dayOfWeek < 7){
            closeWeekend.add(Calendar.DATE, (6-dayOfWeek));  // number of days to add
        } else {
            closeWeekend.add(Calendar.DATE, 6);  // number of days to add
        }
        try {
            freeFriday = calculateFridayNightsForMonths(closeWeekend, months, update);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return freeFriday;
    }

    private static ArrayList<SendMessage> calculateFridayNightsForMonths(Calendar comingFriday, int monthsNum, Update update) throws ParseException {
        ArrayList<SendMessage> freeFriday = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(checkSharon(comingFriday) && checkZivChildrens(comingFriday) && checkShakedMenses(comingFriday) && checkZivMenses(comingFriday)){
            SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
            freeFriday.add(sendMessage.setText(sdf.format(comingFriday.getTime())));
        }
        int counter = 0;
        SimpleDateFormat hebrowFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (counter != monthsNum*4){
            comingFriday.add(Calendar.DATE, 7);
            if(checkSharon(comingFriday) && checkZivChildrens(comingFriday) && checkShakedMenses(comingFriday) && checkZivMenses(comingFriday)){
                SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
                freeFriday.add(sendMessage.setText(hebrowFormat.format(comingFriday.getTime())));
            }
            counter++;
        }

        if(freeFriday.size() == 0){
            SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
            freeFriday.add(sendMessage.setText("לא נמצאו תאריכים מתאימים בחודש הקרוב :("));
        }
        return freeFriday;
    }


    private static boolean checkSharon(Calendar testWeekend) throws ParseException {
        String date = "2019-04-19";  // Start date with children
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar weekendWithChildrens = Calendar.getInstance();
        weekendWithChildrens.setTime(sdf.parse(date));

        long disff = testWeekend.getTimeInMillis() - weekendWithChildrens.getTimeInMillis();
        long passDays = TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS);
//        System.out.println ("Days: " + TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS));
        return (((passDays/7)%2)>0); // true if available
    }

    private static boolean checkZivChildrens(Calendar testWeekend) throws ParseException {
        String date = "2019-04-26";  // Start date no children
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar weekendWithChildrens = Calendar.getInstance();
        weekendWithChildrens.setTime(sdf.parse(date));

        long disff = testWeekend.getTimeInMillis() - weekendWithChildrens.getTimeInMillis();
        long passDays = TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS);
//        System.out.println ("Days: " + TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS));
        return (((passDays/7)%3)==0); // true if available
    }

    private static boolean checkShakedMenses(Calendar testWeekend) throws ParseException {
        String date = "2019-04-01";  // Start date of menses
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar weekendWithChildrens = Calendar.getInstance();
        weekendWithChildrens.setTime(sdf.parse(date));

        long disff = testWeekend.getTimeInMillis() - weekendWithChildrens.getTimeInMillis();
        long passDays = TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS);
//        System.out.println ("Days: " + TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS));
        return (((passDays+1)%24)>5); // 24-between, 5-5 Menses days
    }

    private static boolean checkZivMenses(Calendar testWeekend) throws ParseException {
        String date = "2019-04-10";  // Start date of menses
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar weekendWithChildrens = Calendar.getInstance();
        weekendWithChildrens.setTime(sdf.parse(date));

        long disff = testWeekend.getTimeInMillis() - weekendWithChildrens.getTimeInMillis();
        long passDays = TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS);
//        System.out.println ("Days: " + TimeUnit.DAYS.convert(disff, TimeUnit.MILLISECONDS));
        return (((passDays+1)%30)>5); // 30-between, 5-5 Menses days
    }
}
